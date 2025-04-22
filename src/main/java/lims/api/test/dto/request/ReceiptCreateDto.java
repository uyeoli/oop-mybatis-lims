package lims.api.test.dto.request;

import lims.api.test.entity.Receipt;
import lims.api.test.enums.TestStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReceiptCreateDto {

    private Long requestId;
    private String receiptNumber;
    private LocalDate receiptDate;
    private List<TestItemCreateDto> testItems = new ArrayList<>();
    private final TestStatus testStatus = TestStatus.RECEIPT_TEMPORARY_SAVE;

    public Receipt toReceiptEntity() {
        Receipt receipt = new Receipt();
        receipt.setRequestId(this.getRequestId());
        receipt.setReceiptNumber(this.getReceiptNumber());
        receipt.setTestStatus(testStatus);
        return receipt;
    }


}

