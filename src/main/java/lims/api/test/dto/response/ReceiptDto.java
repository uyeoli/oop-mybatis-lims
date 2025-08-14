package lims.api.test.dto.response;

import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReceiptDto {

    private Long id;
    private String receiptNumber;
    private LocalDate receiptDate;
    private List<TestItemDto> testItems = new ArrayList<>();

    public static ReceiptDto of(Receipt receipt) {
        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setId(receipt.getId());
        receiptDto.setReceiptNumber(receipt.getReceiptNumber());
        return receiptDto;
    }


}
