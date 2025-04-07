package lims.api.test.dto.request;

import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptTestItemInfoDto {
    private Long id;
    private Long receiptId;
    private String itemName;

    public TestItem toTestItemEntity(ReceiptTestItemInfoDto receiptTestItemInfoDto) {
        TestItem testItem = new TestItem();
        testItem.setId(receiptTestItemInfoDto.getId());
        testItem.setReceiptId(receiptTestItemInfoDto.getReceiptId());
        testItem.setItemName(receiptTestItemInfoDto.getItemName());
        return testItem;
    }
}
