package lims.api.test.service.impl;

import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
import lims.api.test.repository.ReceiptRepository;
import lims.api.test.repository.TestItemRepository;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static lims.api.common.util.ValidationUtil.isNew;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final TestItemRepository testItemRepository;

    @Override
    public List<ReceiptDto> findAll() {
        List<ReceiptDto> receiptList = receiptRepository.findAll().stream().map(Receipt::of).collect(Collectors.toList());
        receiptList.forEach(receipt -> {
            receipt.setTestItems(testItemRepository.findItems(receipt.getId()));
        });
        return receiptList;
    }

    @Override
    public void receipt(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = receiptInfoDto.toEntity(receiptInfoDto);
        if(isNew(receipt.getId())) {
            save(receipt);
        } else {
            update(receipt);
        }
    }

    private void save(Receipt receipt) {
        receiptRepository.save(receipt);
        Long receiptId = receipt.getId();

        receipt.getTestItems().forEach(item -> {
            item.setReceiptId(receiptId);
            testItemRepository.save(item);
        });
    }

    private void update(Receipt receipt) {
        receiptRepository.update(receipt);

        receipt.getTestItems().forEach(item -> {
            testItemRepository.delete(item.getId());
            testItemRepository.save(item);
        });
    }

    @Override
    public void delete(Long id) {
        testItemRepository.deleteByReceiptId(id);
        receiptRepository.deleteById(id);
    }



}
