package lims.api.approve.repository;

import lims.api.approve.dto.request.ApprovalRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalRepository {
    private final ApprovalMapper approvalMapper;
    private final ApproverMapper approverMapper;

    public void draft(Approval approval) {

        approvalMapper.insert(approval);

        for(Approver approver : approval.getApprovers()) {
            approver.setApproveId(approval.getId());
            approverMapper.insert(approver);
        }

    }

    public Approval findById(Long approvalId) {
        Approval approval = approvalMapper.findById(approvalId);
        List<Approver> approvers = approverMapper.findByApprovalId(approvalId);
        approval.setApprovers(approvers);
        return approval;
    }

    public void approve(Approval approval, ApprovalRequestDto approvalRequestDto) {
        Approver approver = approval.getCurrentApprover(approvalRequestDto);
        approver.approve();
        approverMapper.save(approver);

        if(approval.isAllApproved()) {
            approval.complete();
            approvalMapper.save(approval);
        }
    }

    //1. 승인자가 반려 시 -> 승인이 반려상태로 변경
    public void reject(Approval approval, RejectRequestDto rejectRequestDto) {
        approval.reject(rejectRequestDto);
        approverMapper.save(approver);
    }
}
