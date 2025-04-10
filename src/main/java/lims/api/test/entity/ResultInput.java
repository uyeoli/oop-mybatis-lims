package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultInput {

    Long id;
    Long receiptId;
    Long approveId;
    List<TestItemResult> itemResults;
}
