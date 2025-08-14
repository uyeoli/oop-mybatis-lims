package lims.api.test.dto.request;

import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemModifyDto {
    private Long id;
    private String itemName;

    public TestItem toEntity() {
        TestItem testItem = new TestItem();
        testItem.setItemName(this.getItemName());
        return testItem;
    }
}
