package lims.api.approve.service;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;

import java.util.List;

public interface ApprovalService {

    List<ApproveDto> findAll();

    void approve(ApproveInfoDto approveInfoDto);

    void reject(RejectInfoDto rejectInfoDto);



}
