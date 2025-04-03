package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.enums.ApprovalRequestDomain;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.ReceiptApproverInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;
    @Override
    public List<ApproveDto> findAll() {
        return null;
    }

    @Override
    public Approval approveRequest(ApprovalRequestDomain approvalRequestDomain, List<ReceiptApproverInfoDto> approvers) {
        Approval approval = new Approval(approvalRequestDomain);
        createApprove(approval);
        saveApprovers(approval.getId(), approvers);

        return approval;
    }

    private void createApprove(Approval approval) {
        approvalRepository.insertApproval(approval);
    }

    private void saveApprovers(Long approveId, List<ReceiptApproverInfoDto> approvers) {

    }

    @Override
    public void approve(ApproveInfoDto approveInfoDto) {

    }

    @Override
    public void reject(RejectInfoDto rejectInfoDto) {

    }

}
