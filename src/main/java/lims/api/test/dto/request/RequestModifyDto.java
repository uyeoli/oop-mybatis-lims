package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestModifyDto {

    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;


}
