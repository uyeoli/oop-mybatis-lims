package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalStatus;
import lims.api.approve.enums.ApproverType;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.vo.DraftedApprover;
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
    public Approval draft(List<DraftedApprover> draftedApprovers) {
        Approval approval = new Approval(LocalDate.now(), ApprovalStatus.DRAFT);
        createApprove(approval);
        saveApprovers(approval.getId(), draftedApprovers);
        return approval;
    }

    private void createApprove(Approval approval) {
        approvalRepository.insertApproval(approval);
    }

    private void saveApprovers(Long approveId, List<DraftedApprover> draftedApprovers) {
        List<Approver> approvers = draftedApprovers.stream().map(DraftedApprover::toEntity).collect(Collectors.toList());
        approvers.forEach(approver -> {
            approver.setApproveId(approveId);
            approvalRepository.insertApprover(approver);
        });
    }

    // 승인 시 승인자의 상태값 변경.
    @Override
    public void approve(Long approvalId, ApproveRequestDto approveRequestDto) {
        Approver approver = approveRequestDto.toEntity();
        approvalRepository.approve(approver);

        if(isLastApprover(approvalId)) {
            finishApproval(approvalId);
        }
    }

    private boolean isLastApprover(Long approvalId) {
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
    public void reject(RejectRequestDto rejectRequestDto) {
        Approver approver = rejectRequestDto.getCompanion().toEntity();
        approvalRepository.reject(approver);
    }

}
