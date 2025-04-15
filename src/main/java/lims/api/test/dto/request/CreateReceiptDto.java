package lims.api.test.dto.request;

import lims.api.test.entity.Receipt;
import lims.api.test.entity.TestItem;
import lims.api.test.vo.ReceiptTestItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateReceiptDto {

    private Long id;
    private Long requestId;
    private String receiptName;
    private String receiptNumber;
    private List<ReceiptTestItem> testItems = new ArrayList<>();

    public Receipt toEntity() {
        Receipt receipt = new Receipt();
        receipt.setId(this.getId());
        receipt.setRequestId(this.getRequestId());
        receipt.setReceiptName(this.getReceiptName());
        receipt.setReceiptNumber(this.getReceiptNumber());
//        receipt.setTestItems(this.getTestItems());
        return receipt;
    }


}

