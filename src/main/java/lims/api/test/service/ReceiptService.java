package lims.api.test.service;

import lims.api.test.dto.request.ReceiptApproverInfoDto;
import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> findAll();

    void save(ReceiptInfoDto receiptInfoDto);

    void delete(Long id);

    void approveRequest(Long id, List<ReceiptApproverInfoDto> receiptApproverInfoDto);
}
