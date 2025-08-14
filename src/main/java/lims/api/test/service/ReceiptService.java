package lims.api.test.service;

import lims.api.test.dto.request.ReceiptModifyDto;
import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.ReceiptCreateDto;
import lims.api.test.dto.response.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> findAll();

    void insert(ReceiptCreateDto receiptCreateDto);

    void update(Long id, ReceiptModifyDto receiptModifyDto);

    void delete(Long id);

    void draft(Long id, List<ReceiptApproveDto> receiptApproveDto);
}
