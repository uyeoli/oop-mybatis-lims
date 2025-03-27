package lims.api.test.entity;

import lims.api.test.dto.response.TestStartResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestStart {
    private String id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private String testNo;

    public static TestStartResponseDto of(TestStart entity) {
        return TestStartResponseDto.builder()
                .id(entity.getId())
                .testTitle(entity.getTestTitle())
                .sampleName(entity.getSampleName())
                .sampleQuantity(entity.getSampleQuantity())
                .testNo(entity.getTestNo())
                .build();
    }

}
