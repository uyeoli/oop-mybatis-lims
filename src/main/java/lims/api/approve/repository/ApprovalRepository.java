package lims.api.approve.repository;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApprovalRepository {
    private final ApprovalMapper approvalMapper;
    private final ApproverMapper approverMapper;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

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

    @Transactional
    public void approve(Long approvalId, Approver approver){
        try {
            approver.approve();
            log.info("approve log = {}", atomicInteger.incrementAndGet() + "번승인자 : " + approver.getApproverName());
            approverMapper.save(approver); //현재 승인자 키값으로 승인 완료처리
            Approval approval = findById(approvalId);
            Thread.sleep(2000);
            boolean isAllApproved = approval.isAllApproved(approver);
            log.info("allApproved log = {}", isAllApproved);
            if(isAllApproved) {
                approval.complete();
                log.info("complete = {}", "승인완료");
                approvalMapper.save(approval);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void reject(Approval approval) {
        approval.reject();
        approvalMapper.save(approval);
    }
}
