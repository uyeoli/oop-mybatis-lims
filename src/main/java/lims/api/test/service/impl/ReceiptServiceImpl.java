package lims.api.test.service.impl;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApprovalRequestDomain;
import lims.api.approve.service.ApprovalService;
import lims.api.test.dto.request.ReceiptApproverInfoDto;
import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.entity.Receipt;
import lims.api.test.repository.ReceiptRepository;
import lims.api.test.repository.TestItemRepository;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
