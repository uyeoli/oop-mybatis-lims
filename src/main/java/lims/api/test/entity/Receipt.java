package lims.api.test.entity;

import lims.api.test.dto.request.ReceiptModifyDto;
import lims.api.test.dto.request.TestItemModifyDto;
import lims.api.test.enums.TestStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Receipt {
    private Long id;
    private Long requestId;
    private String receiptNumber;
    private Long approveId;
    private LocalDate receiptDate;
    private TestStatus testStatus;
    private List<TestItem> testItems;


    public void modify(ReceiptModifyDto receiptModifyDto) {
        this.setReceiptNumber(receiptModifyDto.getReceiptNumber());
        this.modifyTestItem(receiptModifyDto.getModifiedTestItems());
    }

    private void modifyTestItem(List<TestItemModifyDto> modifiedTestItems) {
        List<TestItem> testItems = modifiedTestItems.stream().map(TestItemModifyDto::toEntity).toList();
        this.setTestItems(testItems);
    }


}
