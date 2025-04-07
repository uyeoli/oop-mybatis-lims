package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalRequestDomain;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.ReceiptApproverInfoDto;
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
            receipt.setTestItems(testItemRepository.findItems(receipt.getId()));
        });
        return receiptList;
    }

    @Override
    public void save(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = receiptInfoDto.toReceiptEntity(receiptInfoDto);
        //TODO - 저장할때와 수정할때 같은 DTO를 씀. 이럴경우 분리를 해야할까? ->
        // 만약 생성DTO와 수정DTO를 둘 다 가지고있는 저장 DTO로 받는다면 저장일때는 생성DTO에, 수정일때는 수정 DTO에 세팅해야한다.
        // 이게 좋은 방법일까? 클라이언트도 그걸 구분해서 보내줘야하지 않나?
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
        //TODO - ApprovalRequestDomain은 클라이언트에서 받아야할지 각각의 서비스에서 세팅해야할지
        Approval approval = approvalService.approveRequest(ApprovalRequestDomain.RECEIPT, approvers);

        Receipt receipt = receiptRepository.findById(id);
        receipt.setApproveId(approval.getId());
        receiptRepository.updateApproveKey(receipt);
    }

    //시험을 의뢰한다.
    // 접수한다.
    // 접수 승인요청을 보낸다.
}
