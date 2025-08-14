package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApprovalRequestDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.repository.ApprovalRepository;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.vo.DraftedApprover;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;

    @Override
    public Approval draft(List<DraftedApprover> draftedApprovers) {
        List<Approver> approvers = draftedApprovers.stream().map(DraftedApprover::toEntity).collect(Collectors.toList());
        Approval approval = new Approval(approvers);
        approvalRepository.draft(approval);
        return approval;
    }


    @Override
    public void approve(Long approvalId, ApprovalRequestDto approvalRequestDto) {
        Approval approval = approvalRepository.findById(approvalId);
        Approver approver = approvalRequestDto.toEntity();
        approvalRepository.approve(approval, approver);
    }


    @Override
    public void reject(Long approvalId) {
        Approval approval = approvalRepository.findById(approvalId);
        approvalRepository.reject(approval);
    }

}
