package lims.api.test.dto.request;

import lims.api.test.entity.TestItemResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyTestItemResultDto {
    private Long id;
    private String testerName;
    private String result;


    public TestItemResult toTestItemResultEntity(ModifyTestItemResultDto modifyTestItemResultDto) {
        TestItemResult testItemResult = new TestItemResult();
        testItemResult.setId(modifyTestItemResultDto.getId());
        testItemResult.setTesterName(modifyTestItemResultDto.getTesterName());
        testItemResult.setResult(modifyTestItemResultDto.getResult());
        return testItemResult;
    }

}
