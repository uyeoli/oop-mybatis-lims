package lims.api.test.dto.response;

import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemDto {
    private Long id;
    private Long receiptId;
    private String itemName;

    public static TestItemDto of(TestItem testItem) {
        TestItemDto testItemDto = new TestItemDto();
        testItemDto.setId(testItem.getId());
        testItemDto.setItemName(testItem.getItemName());
        testItemDto.setReceiptId(testItem.getReceiptId());
        return testItemDto;
    }

}
