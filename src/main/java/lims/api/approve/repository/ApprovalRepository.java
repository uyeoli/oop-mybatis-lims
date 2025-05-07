package lims.api.approve.repository;

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
            approver.setApprovalId(approval.getId());
            approverMapper.insert(approver);
        }

    }

    public Approval findById(Long approvalId) {
        Approval approval = approvalMapper.findById(approvalId);
        List<Approver> approvers = approverMapper.findByApprovalId(approvalId);
        approval.setApprovers(approvers);
        return approval;
    }

    public void approve(Approval approval, Approver approver) {
        Approver currentApprover = approval.getCurrentApprover(approver);
        currentApprover.approve();
        approverMapper.save(currentApprover);

        if(approval.isAllApproved()) {
            approval.complete();
            approvalMapper.save(approval);
        }
    }

    public void reject(Approval approval) {
        approval.reject();
        approvalMapper.save(approval);
    }
}
