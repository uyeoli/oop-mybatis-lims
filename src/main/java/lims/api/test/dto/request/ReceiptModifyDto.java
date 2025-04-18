package lims.api.test.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReceiptModifyDto {

    private Long id;
    private String receiptNumber;
    private LocalDate receiptDate;
    private List<ReceiptTestItemDto> testItems = new ArrayList<>();


}
