package lims.api.test.entity;

import lims.api.test.dto.response.ReceiptDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Receipt {
    private Long id;
    private Integer requestId;
    private String receiptName;
    private String receiptNumber;
    private List<TestItem> testItems;

    public boolean isNew() {
        return this.id == null || this.id == 0;
    }

}
