package lims.api.test.vo;

import lims.api.test.entity.TestItem;
import lombok.Getter;

@Getter
public class ReceiptTestItem {
    private final Long receiptId;
    private final String itemName;

    public ReceiptTestItem(Long receiptId, String itemName) {
        this.receiptId = receiptId;
        this.itemName = itemName;
    }

    public TestItem toEntity() {
        TestItem testItem = new TestItem();
        testItem.setReceiptId(this.getReceiptId());
        testItem.setItemName(this.getItemName());
        return testItem;
    }
}
