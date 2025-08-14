package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultInput {

    private Long id;
    private Long receiptId;
    private Long approveId;
    private String judgement;
    private List<TestItemResult> itemResults = new ArrayList<>();
}
