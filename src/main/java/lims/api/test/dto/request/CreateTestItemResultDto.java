package lims.api.test.dto.request;

import lims.api.test.entity.TestItemResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTestItemResultDto {
    private Long resultInputId;
    private String testerName;
    private String result;


    public TestItemResult toTestItemResultEntity(CreateTestItemResultDto createTestItemResultDto) {
        TestItemResult testItemResult = new TestItemResult();
        testItemResult.setResultInputId(createTestItemResultDto.getResultInputId());
        testItemResult.setTesterName(createTestItemResultDto.getTesterName());
        testItemResult.setResult(createTestItemResultDto.getResult());
        return testItemResult;
    }

}
