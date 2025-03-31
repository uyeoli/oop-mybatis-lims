package lims.api.test.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestDto {

    private Long id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;

}
