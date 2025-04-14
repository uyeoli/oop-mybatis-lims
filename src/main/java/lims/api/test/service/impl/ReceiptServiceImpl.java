package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.ModifyReceiptDto;
import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.CreateReceiptDto;
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
        //ReceiptDto는 존재하지않는 애라 정적팩토리 메소드 사용. -> 정적팩토리 사용안하고 일반 메소드 사용 시 문맥상 맞지 않음 -> new ReceiptDto().of ?
        List<ReceiptDto> receiptList = receiptRepository.findAll().stream().map(ReceiptDto::of).toList();
        receiptList.forEach(receipt -> {
            receipt.setTestItems(testItemRepository.findItems(receipt.getId()).stream().map(TestItemDto::of).toList());
        });
        return receiptList;
    }

    @Override
    public void create(CreateReceiptDto createReceiptDto) {
        Receipt receipt = createReceiptDto.toEntity();
        receiptRepository.insert(receipt);


        List<TestItem> testItems = createReceiptDto.getTestItems().stream().map(item -> item.toEntity(item)).toList();
        insertTestItems(testItems, receipt.getId());
//            receiptRepository.update(receipt);
//            updateTestItems(testItems);
    }

    @Override
    public void modify(ModifyReceiptDto modifyReceiptDto) {

        //수정할 접수 정보 -> entity로 변환
        //접수 update
        //수정된 시험항목 정보 -> { 수정된 시험항목 , 추가된 시험항목, 삭제된 시험항목 }

    }

    private void insertTestItems(List<TestItem> testItems, Long receiptId) {
        testItems.forEach(item -> {
            item.setReceiptId(receiptId);
            testItemRepository.insert(item);
        });
    }

    private void updateTestItems(List<TestItem> testItems) {
        testItems.forEach(item -> {
            testItemRepository.update(item);
        });
    }

    @Override
    public void delete(Long id) {
        testItemRepository.deleteByReceiptId(id);
        receiptRepository.deleteById(id);
    }

    @Override
    public void draft(Long id, List<ReceiptApproveDto> receiptApprovers) {
        List<Approver> approvers = receiptApprovers.stream().map(ReceiptApproveDto::of).toList();

        Approval approval = approvalService.draft(approvers);
        Receipt receipt = receiptRepository.findById(id);
        receipt.setApproveId(approval.getId());
        receiptRepository.updateApproveKey(receipt);
    }

}
