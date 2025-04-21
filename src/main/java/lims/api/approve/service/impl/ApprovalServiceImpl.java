package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalStatus;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.common.enums.UseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;
    @Override
    public List<ApproveDto> findAll() {
        return null;
    }

    @Override
    public Approval draft(List<Approver> approvers) {
        Approval approval = new Approval(LocalDate.now(), ApprovalStatus.DRAFT);//승인객체는 저장할때만 생성. 하지만 상태값은 계속 변함
        createApprove(approval); //Approval - 승인, Approver - 승인자
        saveApprovers(approval.getId(), approvers);
        return approval;
    }

    private void createApprove(Approval approval) {
        approvalRepository.insertApproval(approval);
    }

    private void saveApprovers(Long approveId, List<Approver> approvers) {
        approvers.forEach(approver -> {
            approver.setApproveId(approveId);
            approver.setApproveYn(UseType.N);
            approvalRepository.insertApprover(approver);
        });
    }

    // 승인 시 승인자의 상태값 변경.
    @Override
    public void approve(ApproveInfoDto approveInfoDto) {
        Approver approver = ApproveInfoDto.of(approveInfoDto);
        approvalRepository.approve(approver);

        isLastApprover(approver);
    }

    private boolean isLastApprover(Approver approver) {
        Long approveId = approver.getApproveId();
        List<Approver> approvers = approvalRepository.findByApproveId(approveId);


        return false;
    }

    @Override
    //반려 시 승인의 상태값 변경
    public void reject(RejectInfoDto rejectInfoDto) {
        Approver approver = RejectInfoDto.of(rejectInfoDto);
        approvalRepository.reject(approver);
    }



}
