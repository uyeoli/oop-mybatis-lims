package lims.api.test.dto.response;

import lims.api.test.entity.TestItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptDto {

    private Long id;
    private String receiptName;
    private String receiptNumber;
    private TestItem testItem;


}
