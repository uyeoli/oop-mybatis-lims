package lims.api.test.dto.request;

import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReceiptInfoDto {

    private Long id;
    private String receiptName;
    private String receiptNumber;
    private List<TestItem> testItems;

    public Receipt toEntity(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = new Receipt();
        receipt.setReceiptName(receiptInfoDto.receiptName);
        receipt.setReceiptNumber(receiptInfoDto.receiptNumber);
        receipt.setTestItem(receiptInfoDto.getTestItems());
        return receipt;
    }
}
