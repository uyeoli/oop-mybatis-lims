package lims.api.test.dto.request;

import lims.api.test.entity.TestItemResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestItemResultModifyDto {
    private Long id;
    private String testerName;
    private String result;


    public TestItemResult toTestItemResultEntity(TestItemResultModifyDto testItemResultModifyDto) {
        TestItemResult testItemResult = new TestItemResult();
        testItemResult.setId(testItemResultModifyDto.getId());
        testItemResult.setTesterName(testItemResultModifyDto.getTesterName());
        testItemResult.setResult(testItemResultModifyDto.getResult());
        return testItemResult;
    }

}
