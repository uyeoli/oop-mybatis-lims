package lims.api.approve.service;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.vo.ApprovalParticipant;
import lims.api.approve.vo.DraftedApprover;

import java.util.List;

public interface ApprovalService {


    Approval draft(List<ApprovalParticipant> approvers);

    void approve(ApproveInfoDto approveInfoDto);

    void reject(RejectInfoDto rejectInfoDto);



}
