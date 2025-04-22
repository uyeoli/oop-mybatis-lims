package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproverInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalStatus;
import lims.api.approve.enums.ApproverType;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.vo.ApprovalParticipant;
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
    public void approve(Long approvalId, ApproverInfoDto approverInfoDto) {
        Approver approver = ApproverInfoDto.of(approverInfoDto);
        approvalRepository.approve(approver);

        if(isFinish(approvalId)) {
            finishApproval(approvalId);
        }
    }

    private boolean isFinish(Long approvalId) {
        List<Approver> approvers = approvalRepository.findApprovers(approvalId);
        return approvers.stream()
                .allMatch(approver -> approver.getApproverType() == ApproverType.APPROVE);
    }

    private void finishApproval(Long approvalId) {
        Approval approval = approvalRepository.findById(approvalId);
        approval.complete();
        approvalRepository.finishApproval(approval);
    }

    @Override
    public void reject(RejectInfoDto rejectInfoDto) {
        Approver approver = RejectInfoDto.of(rejectInfoDto);
        approvalRepository.reject(approver);
    }

}
