package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalRequestDomain;
import lims.api.common.enums.UseType;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
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
    public Approval approveRequest(ApprovalRequestDomain approvalRequestDomain, List<Approver> approvers) {
        Approval approval = new Approval(approvalRequestDomain);
        createApprove(approval); //Approval - 승인, Approver - 승인자
        saveApprovers(approval.getId(), approvers);

        return approval;
    }

    private void createApprove(Approval approval) {
        approvalRepository.insertApproval(approval);
    }

    private void saveApprovers(Long approveId, List<Approver> approvers) {
        approvers.forEach(approver -> {
            approver.setApproveId(approveId);
            approver.setApproveYn(UseType.N);
            approvalRepository.insertApprover(approver);
        });
    }
    //승인 요청 - 승인 , 반려
    @Override
    public void approve(ApproveInfoDto approveInfoDto) {
        Approver approver = ApproveInfoDto.of(approveInfoDto);
        approvalRepository.approve(approver);
    }

    @Override
    public void reject(RejectInfoDto rejectInfoDto) {
        Approver approver = RejectInfoDto.of(rejectInfoDto);
        approvalRepository.reject(approver);
    }

}
