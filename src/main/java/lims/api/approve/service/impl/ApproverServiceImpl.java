package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.entity.Approver;
import lims.api.approve.repository.ApproverRepository;
import lims.api.approve.service.ApproverService;
import lims.api.approve.vo.DraftedApprover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApproverServiceImpl implements ApproverService {
    private final ApproverRepository approverRepository;

    @Override
    public void saveApprovers(Long approvalId, List<DraftedApprover> draftedApprovers) {
        List<Approver> approvers = draftedApprovers.stream().map(DraftedApprover::toEntity).collect(Collectors.toList());
        approvers.forEach(approver -> {
            approver.setApproveId(approvalId);
            approverRepository.insert(approver);
        });
    }

    //승인 - 전체 흐름
    //승인자 - 개별 흐름
    //1 : N

    @Override
    public void approve(ApproveRequestDto approveRequestDto) {
        Approver approver = approveRequestDto.toEntity();
        approver.approve();
        approverRepository.save(approver);
    }

    @Override
    public void reject(RejectRequestDto rejectRequestDto) {
        Approver approver = rejectRequestDto.getCompanion().toEntity();
        approver.reject();
        approverRepository.save(approver);
    }

}
