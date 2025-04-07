package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalRequestDomain;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.ReceiptApproverInfoDto;
import lims.api.test.dto.request.ReceiptInfoDto;
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

    //승인 요청 - 접수, 결과입력
    //승인, 반려 - 승인서비스

    @Override
    public List<ReceiptDto> findAll() {
        List<ReceiptDto> receiptList = receiptRepository.findAll().stream().map(ReceiptDto::of).toList();
        receiptList.forEach(receipt -> {
            receipt.setTestItems(testItemRepository.findItems(receipt.getId()).stream().map(TestItemDto::of).toList());
        });
        return receiptList;
    }

    @Override
    public void save(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = receiptInfoDto.toReceiptEntity(receiptInfoDto);
        //
        List<TestItem> testItems = receiptInfoDto.getTestItems().stream().map(item -> item.toTestItemEntity(item)).toList();
        if(receipt.isNew()) {
            receiptRepository.insert(receipt);
            insertTestItems(testItems, receipt.getId());
        } else {
            receiptRepository.update(receipt);
            updateTestItems(testItems);
        }
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
    public void approveRequest(Long id, List<ReceiptApproverInfoDto> receiptApprovers) {
        List<Approver> approvers = receiptApprovers.stream().map(ReceiptApproverInfoDto::of).toList();

        //1. 사용자가 승인을 요청한다. - Draft(List<Approver>) - id
        //2. 승인자는 여러명일 수 있다. -
        //3. 승인자는 승인한다. - approve(Approver, id) - 반환타입 고민

        //5. 승인자는 반려할 수 있다. - reject(Approver, id) - 반환타입 고민
        //6. 반려 시 사용자는 다시 승인을 요청해야한다. - Draft

        Approval approval = approvalService.approveRequest(ApprovalRequestDomain.RECEIPT, approvers);

        Receipt receipt = receiptRepository.findById(id);
        receipt.setApproveId(approval.getId());
        receiptRepository.updateApproveKey(receipt);
    }

}
