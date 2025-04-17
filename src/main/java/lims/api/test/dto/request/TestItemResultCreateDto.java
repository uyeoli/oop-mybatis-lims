package lims.api.test.dto.request;

import lims.api.test.entity.TestItemResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemResultCreateDto {
    private Long resultInputId;
    private String testerName;
    private String result;


    public TestItemResult toTestItemResultEntity(TestItemResultCreateDto testItemResultCreateDto) {
        TestItemResult testItemResult = new TestItemResult();
        testItemResult.setResultInputId(testItemResultCreateDto.getResultInputId());
        testItemResult.setTesterName(testItemResultCreateDto.getTesterName());
        testItemResult.setResult(testItemResultCreateDto.getResult());
        return testItemResult;
    }

}
