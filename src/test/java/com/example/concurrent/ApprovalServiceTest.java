package com.example.concurrent;

import lims.api.LimsApplication;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.repository.ApprovalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(classes = LimsApplication.class)
public class ApprovalServiceTest {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Test
    void approveTest() throws InterruptedException {
            Long approvalId = 4L;
            Approval approval = approvalRepository.findById(approvalId);
            List<Approver> approvers = approval.getApprovers();

            ExecutorService executor = Executors.newFixedThreadPool(approvers.size());
            CountDownLatch latch = new CountDownLatch(approvers.size());

            for (int i = 0; i < approvers.size(); i++) {
                Approver approver = approvers.get(i);
                executor.submit(() -> {
                    try {
                        approvalRepository.approve(approvalId, approver);
                    }  finally {
                        latch.countDown();
                    }
                });
            }
            latch.await();
            executor.shutdown();
    }

}
