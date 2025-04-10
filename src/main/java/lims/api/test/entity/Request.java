package lims.api.test.entity;

import lims.api.test.dto.response.RequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private Long id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;

}
