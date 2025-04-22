package lims.api.approve.service;

import lims.api.approve.dto.request.ApproverInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.vo.ApprovalParticipant;

import java.util.List;

public interface ApprovalService {


    Approval draft(List<ApprovalParticipant> approvers);

    void approve(Long id, ApproverInfoDto approverInfoDto);

    void reject(RejectInfoDto rejectInfoDto);



}
