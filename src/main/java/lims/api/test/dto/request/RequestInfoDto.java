package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestInfoDto {

    private Long id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;

    public Request toEntity(RequestInfoDto requestInfoDto) {
        Request request = new Request();
        request.setId(requestInfoDto.getId());
        request.setTestTitle(requestInfoDto.getTestTitle());
        request.setSampleName(requestInfoDto.getSampleName());
        request.setSampleQuantity(requestInfoDto.getSampleQuantity());
        return request;
    }


}
