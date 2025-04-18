package lims.api.test.dto.request;

import lims.api.test.entity.Receipt;
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
    private List<ReceiptTestItemDto> testItems = new ArrayList<>();

    public Receipt toReceiptEntity() {
        Receipt receipt = new Receipt();
        receipt.setRequestId(this.getRequestId());
        receipt.setReceiptNumber(this.getReceiptNumber());
        receipt.setReceiptDate(this.receiptDate);
        return receipt;
    }


}

