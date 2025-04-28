package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalStatus;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.repository.ApproverRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.service.ApproverService;
import lims.api.approve.vo.DraftedApprover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;

    @Override
    public Approval draft(List<DraftedApprover> draftedApprovers) {
        Approval approval = new Approval(LocalDate.now(), ApprovalStatus.DRAFT);
        createApproval(approval);
        approverService.saveApprovers(approval.getId(), draftedApprovers);
        return approval;
    }

    private void createApproval(Approval approval) {
        approvalRepository.insert(approval);
    }


    @Override
    public void approve(Long approvalId, ApproveRequestDto approveRequestDto) {
        approverService.approve(approveRequestDto);

        if(isAllApproved(approvalId)) {
            finishApproval(approvalId);
        }
    }


    private boolean isAllApproved(Long approvalId) {
        List<Approver> approvers = approvalRepository.findApprovers(approvalId); //모든 승인자 조회
        return approvers.stream()
                .allMatch(approver -> approver.isApproved()); //
    }


    private void finishApproval(Long approvalId) {
        Approval approval = approvalRepository.findById(approvalId);
        approval.complete();
        approvalRepository.save(approval);
    }


    ////approval의 상태
    //    //approver의 상태
    @Override
    public void reject(Long approvalId, RejectRequestDto rejectRequestDto) { //네이밍
        approverService.reject(rejectRequestDto);
        Approval approval = approvalRepository.findById(approvalId);
        approvalRepository.save(approval);
    }
}
