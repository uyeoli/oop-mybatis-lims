package lims.api.approve.service;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;

import java.util.List;

public interface ApprovalService {

    List<ApproveDto> findAll();

    Approval draft(List<Approver> approvers);

    void approve(ApproveInfoDto approveInfoDto);

    void reject(RejectInfoDto rejectInfoDto);



}
