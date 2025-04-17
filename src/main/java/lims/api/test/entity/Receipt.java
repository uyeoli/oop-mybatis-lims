package lims.api.test.entity;

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
    private List<TestItem> testItems;


}
