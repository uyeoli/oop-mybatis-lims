package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItem {

    private Long id;
    private Long receiptId;
    private String itemName;
}
