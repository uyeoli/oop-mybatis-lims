package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.service.ApprovalService;
import lims.api.approve.vo.DraftedApprover;
import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.ReceiptCreateDto;
import lims.api.test.dto.request.ReceiptModifyDto;
import lims.api.test.dto.request.TestItemCreateDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.dto.response.TestItemDto;
import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
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
    private final ApprovalService approvalService;

    @Override
    public List<ReceiptDto> findAll() {
        List<ReceiptDto> receiptList = receiptRepository.findAll().stream().map(ReceiptDto::of).toList();
        setTestItems(receiptList);
        return receiptList;
    }

    private void setTestItems(List<ReceiptDto> receiptList) {
        receiptList.forEach(receipt -> {
            List<TestItem> items = testItemRepository.findItems(receipt.getId());
            receipt.setTestItems(items.stream().map(TestItemDto::of).toList());
        });
    }

    @Override
    public void insert(ReceiptCreateDto receiptCreateDto) {
        Receipt receipt = receiptCreateDto.toReceiptEntity();
        receiptRepository.insert(receipt);

        insertTestItems(receipt.getId(), receiptCreateDto.getTestItems());
    }

    private void insertTestItems(Long receiptId, List<TestItemCreateDto> createItems) {
        List<TestItem> testItems = createItems.stream().map(item -> item.toEntity()).toList();
        testItems.forEach(item -> {
            item.setReceiptId(receiptId);
            testItemRepository.insert(item);
        });
    }

    @Override
    public void update(Long id, ReceiptModifyDto receiptModifyDto) {
        Receipt receipt = receiptRepository.findById(id);
        receipt.modify(receiptModifyDto);
        receiptRepository.update(receipt);

        updateTestItems(id, receipt.getTestItems());
    }

    private void updateTestItems(Long receiptId, List<TestItem> modifiedTestItems) {
        testItemRepository.deleteByReceiptId(receiptId);
        modifiedTestItems.forEach(item -> testItemRepository.insert(item));
    }

    @Override
    public void delete(Long id) {
        testItemRepository.deleteByReceiptId(id);
        receiptRepository.deleteById(id);
    }

    @Override
    public void draft(Long id, List<ReceiptApproveDto> receiptApprovers) {
        List<DraftedApprover> approvers = receiptApprovers.stream().map(ReceiptApproveDto::of).toList();
        Approval approval = approvalService.draft(approvers);

        Receipt receipt = receiptRepository.findById(id);
        receipt.setApproveId(approval.getId());
        receiptRepository.updateApproveKey(receipt);
    }

}
