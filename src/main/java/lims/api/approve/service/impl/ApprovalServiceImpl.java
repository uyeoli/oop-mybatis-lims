package lims.api.approve.service.impl;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.test.dto.response.ReceiptApproveDto;
import lims.api.approve.service.ApprovalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Override
    public List<ApproveDto> findAll() {
        return null;
    }


    @Override
    public void approve(ApproveInfoDto approveInfoDto) {

    }
}
