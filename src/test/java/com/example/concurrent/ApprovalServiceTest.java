package com.example.concurrent;

import lims.api.LimsApplication;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LimsApplication.class)
public class ApprovalServiceTest {
    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private ApprovalRepository approvalRepository;

    @Test
    void approve_test() throws InterruptedException {
            Long approvalId = 1L;
            Approval approval = approvalRepository.findById(approvalId);
            List<Approver> approvers = approval.getApprovers();

            ExecutorService executor = Executors.newFixedThreadPool(approvers.size());
            CountDownLatch latch = new CountDownLatch(approvers.size());

            for (int i = 0; i < approvers.size(); i++) {
                final int threadNum = i + 1;
                Approver approver = approvers.get(i);

                executor.submit(() -> {
                    try {
                        System.out.println("Thread" + threadNum + " -> 승인 시작: " + approver.getApproverName());

                        approvalRepository.approve(approvalId, approver, () -> {
                            System.out.println("Thread" + threadNum + " -> isAllApproved 체크");
                        });

                        System.out.println("Thread" + threadNum + " -> 승인 완료: " + approver.getApproverName());
                    } finally {
                        latch.countDown();
                    }
                });
            }

            latch.await();
            executor.shutdown();

            System.out.println("=== 최종 Approval 상태 확인 ===");
            Approval finishedApproval = approvalRepository.findById(approvalId);
            System.out.println("최종 승인 상태 = " + finishedApproval.getApprovalStatus());

    }

}
