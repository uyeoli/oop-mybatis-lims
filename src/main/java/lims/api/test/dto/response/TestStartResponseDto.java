package lims.api.test.dto.response;

import lims.api.test.entity.TestStart;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestStartResponseDto {

    private String id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private String testNo;

    //입력하는 데이터가 필드명이 명시

}
