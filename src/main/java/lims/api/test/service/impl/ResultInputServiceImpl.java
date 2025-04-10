package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.CreateResultInputDto;
import lims.api.test.dto.request.ModifyResultInputDto;
import lims.api.test.dto.request.ResultInputApproveDto;
import lims.api.test.dto.response.ResultInputDto;
import lims.api.test.entity.ResultInput;
import lims.api.test.entity.TestItemResult;
import lims.api.test.repository.ResultInputRepository;
import lims.api.test.repository.TestItemResultRepository;
import lims.api.test.service.ResultInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultInputServiceImpl implements ResultInputService {
    private final ResultInputRepository resultInputRepository;
    private final TestItemResultRepository testItemResultRepository;
    private final ApprovalService approvalService;
    @Override
    public List<ResultInputDto> findAll() {
//        List<ResultInputDto> resultInputList = resultInputRepository.findAll().stream().map(ResultInputDto::of).toList();
        return null;
    }

    @Override
    public void create(CreateResultInputDto createResultInputDto) {
        ResultInput resultInput = createResultInputDto.toResultInputEntity(createResultInputDto);
        List<TestItemResult> testItemResults = createResultInputDto.getTestItemResults().stream().map(item -> item.toTestItemResultEntity(item)).toList();

        resultInputRepository.insert(resultInput);
        insertTestItemResult(testItemResults, resultInput.getId());
    }

    private void insertTestItemResult(List<TestItemResult> testItemResults, Long resultInputId) {
        testItemResults.forEach(item -> {
            item.setResultInputId(resultInputId);
            testItemResultRepository.insert(item);
        });
    }

    @Override
    public void update(ModifyResultInputDto modifyResultInputDto) {
        ResultInput resultInput = modifyResultInputDto.toResultInputEntity(modifyResultInputDto);
        List<TestItemResult> modifiedTestItemResults = modifyResultInputDto.getTestItemResults().stream().map(item -> item.toTestItemResultEntity(item)).toList();

        resultInputRepository.update(resultInput);
        updateTestItemResults(modifiedTestItemResults);
    }

    private void updateTestItemResults(List<TestItemResult> modifiedTestItemResults) {
        modifiedTestItemResults.forEach(item -> testItemResultRepository.update(item));
    }

    @Override
    public void delete(Long id) {
        resultInputRepository.deleteById(id);
    }

    @Override
    public void draft(Long id, List<ResultInputApproveDto> resultInputApprovers) {
        List<Approver> approvers = resultInputApprovers.stream().map(ResultInputApproveDto::of).toList();
        Approval approval = approvalService.draft(approvers);

        ResultInput resultInput = resultInputRepository.findById(id);
        resultInput.setApproveId(approval.getId());
        resultInputRepository.updateApproveKey(resultInput);
    }
}
