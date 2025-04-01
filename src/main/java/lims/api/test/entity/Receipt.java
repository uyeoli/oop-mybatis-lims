package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Receipt {
    private Long id;
    private Integer requestId;
    private String receiptName;
    private String receiptNumber;
    private List<TestItem> testItems = new ArrayList<>();

    public boolean isNew() {
        return this.id == null || this.id == 0;
    }

}
