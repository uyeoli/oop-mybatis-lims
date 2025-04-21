package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalStatus;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.vo.ApprovalParticipant;
import lims.api.approve.vo.DraftedApprover;
import lims.api.common.enums.UseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;

    @Override
    public Approval draft(List<ApprovalParticipant> approvalParticipants) {
        Approval approval = new Approval(LocalDate.now(), ApprovalStatus.DRAFT);
        createApprove(approval);
        saveApprovers(approval.getId(), approvalParticipants);
        return approval;
    }

    private void createApprove(Approval approval) {
        approvalRepository.insertApproval(approval);
    }

    private void saveApprovers(Long approveId, List<ApprovalParticipant> approvalParticipants) {
        List<Approver> approvers = approvalParticipants.stream().map(ApprovalParticipant::toEntity).collect(Collectors.toList());
        approvers.forEach(approver -> {
            approver.setApproveId(approveId);
            approvalRepository.insertApprover(approver);
        });
    }

    // 승인 시 승인자의 상태값 변경.
    @Override
    public void approve(ApproveInfoDto approveInfoDto) {
        Approver approver = ApproveInfoDto.of(approveInfoDto);
        approvalRepository.approve(approver);

        if(isLastApprover(approver)) {
            approvalRepository.finishApprove(approveInfoDto.getId());
        }
    }

    private boolean isLastApprover(Approver currentApprover) {
        Long approveId = currentApprover.getApproveId();
        List<Approver> approvers = approvalRepository.findApprovers(approveId);
        if(approvers.stream().iterator().next().getApproveYn().value() == UseType.N.value()) {

        }
        return false;
    }

    @Override
    //반려 시 승인의 상태값 변경
    public void reject(RejectInfoDto rejectInfoDto) {
        Approver approver = RejectInfoDto.of(rejectInfoDto);
        approvalRepository.reject(approver);
    }

}
