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

    public void approve(Long approvalId, Approver approver) {
        approver.approve();
        approverMapper.save(approver); //현재 승인자 키값으로 승인 완료처리

        Approval approval = findById(approvalId); // --동시성 이슈 발생 가능성 있는 코드
        if(approval.isAllApproved()) {
            approval.complete();
            approvalMapper.save(approval);
        }
    }

    public void approve(Long approvalId, Approver approver, Runnable runnable) {
        approver.approve();
        approverMapper.save(approver); //현재 승인자 키값으로 승인 완료처리

        Approval approval = findById(approvalId); // --동시성 이슈 발생 가능성 있는 코드
        // isAllApproved 체크 시점에 콜백 호출
        if (runnable != null) {
            runnable.run();
        }

        if (approval.isAllApproved()) {
            approval.complete();
            approvalMapper.save(approval);
        }
    }

    public void reject(Approval approval) {
        approval.reject();
        approvalMapper.save(approval);
    }
}
