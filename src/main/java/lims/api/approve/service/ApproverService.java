package lims.api.approve.service;

import lims.api.approve.dto.request.ApproveRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.vo.DraftedApprover;

import java.util.List;

public interface ApproverService {

    void saveApprovers(Long approvalId, List<DraftedApprover> draftedApprovers);

    void approve(ApproveRequestDto approveRequestDto);

    void reject(RejectRequestDto rejectRequestDto);

}
