package lims.api.test.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReceiptModifyDto {

    private String receiptNumber;
    private LocalDate receiptDate;
    private List<TestItemModifyDto> modifiedTestItems = new ArrayList<>();

}
