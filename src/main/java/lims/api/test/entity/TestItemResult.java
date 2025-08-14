package lims.api.test.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemResult {

    Long id;

    Long resultInputId;

    String testerName;

    String result;
}
