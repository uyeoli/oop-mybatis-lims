package lims.api.approve.service;

import lims.api.approve.dto.request.ApprovalRequestDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.vo.DraftedApprover;

import java.util.List;

public interface ApprovalService {


    Approval draft(List<DraftedApprover> approvers);

    void approve(Long id, ApprovalRequestDto approvalRequestDto);

    void reject(Long id);



}
