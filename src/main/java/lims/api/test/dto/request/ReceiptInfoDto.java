package lims.api.test.dto.request;

import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReceiptInfoDto {

    private Long id;
    private String receiptName;
    private String receiptNumber;
    private List<TestItem> testItems = new ArrayList<>();

    public Receipt toEntity(ReceiptInfoDto receiptInfoDto) {
        Receipt receipt = new Receipt();
        receipt.setId(receiptInfoDto.getId());
        receipt.setReceiptName(receiptInfoDto.getReceiptName());
        receipt.setReceiptNumber(receiptInfoDto.getReceiptNumber());
        receipt.setTestItems(receiptInfoDto.getTestItems());
        return receipt;
    }
}
