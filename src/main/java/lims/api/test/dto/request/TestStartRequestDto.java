package lims.api.test.dto.request;

import lims.api.test.entity.TestStart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestStartRequestDto {

    private String id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private String testNo;

    public TestStart toEntity(TestStartRequestDto testRequestDto) {
        TestStart request = new TestStart();
        request.setId(testRequestDto.getId());
        request.setTestTitle(testRequestDto.getTestTitle());
        request.setSampleName(testRequestDto.getSampleName());
        request.setSampleQuantity(testRequestDto.getSampleQuantity());
        request.setTestNo(testRequestDto.getTestNo());
        return request;
    }

}
