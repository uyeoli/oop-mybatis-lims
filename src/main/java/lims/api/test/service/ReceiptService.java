package lims.api.test.service;

import lims.api.test.dto.request.ModifyReceiptDto;
import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.CreateReceiptDto;
import lims.api.test.dto.response.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> findAll();

    void create(CreateReceiptDto createReceiptDto);

    void modify(ModifyReceiptDto modityReceiptDto);

    void delete(Long id);

    void draft(Long id, List<ReceiptApproveDto> receiptApproveDto);
}
