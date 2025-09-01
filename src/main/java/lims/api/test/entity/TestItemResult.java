package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemResult {

    private Long id;

    private Long resultInputId;

    private String testerName;

    private String result;
}
