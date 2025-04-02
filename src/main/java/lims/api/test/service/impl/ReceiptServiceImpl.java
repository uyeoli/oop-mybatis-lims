package lims.api.test.service.impl;

import lims.api.test.dto.request.ReceiptApproverInfoDto;
import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.entity.Receipt;
import lims.api.test.repository.ReceiptRepository;
import lims.api.test.repository.TestItemRepository;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final TestItemRepository testItemRepository;


    @Override
    public List<ReceiptDto> findAll() {
        List<ReceiptDto> receiptList = receiptRepository.findAll().stream().map(ReceiptDto::of).toList();
        receiptList.forEach(receipt -> {
            receipt.setTestItems(testItemRepository.findItems(receipt.getId()));
        });
        return receiptList;
    }

    @Override
    public void save(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = receiptInfoDto.toEntity(receiptInfoDto);
        if(receipt.isNew()) {
            create(receipt);
        } else {
            update(receipt);
        }
    }

    private void create(Receipt receipt) {
        receiptRepository.insert(receipt);
        Long receiptId = receipt.getId();

        receipt.getTestItems().forEach(item -> {
            item.setReceiptId(receiptId);
            testItemRepository.insert(item);
        });
    }

    private void update(Receipt receipt) {
        receiptRepository.update(receipt);

        receipt.getTestItems().forEach(item -> {
            testItemRepository.deleteById(item.getId());
            testItemRepository.insert(item);
        });
    }

    @Override
    public void delete(Long id) {
        testItemRepository.deleteByReceiptId(id);
        receiptRepository.deleteById(id);
    }

    @Override
    public void approveRequest(Long id, List<ReceiptApproverInfoDto> approvers) {

    }
}
