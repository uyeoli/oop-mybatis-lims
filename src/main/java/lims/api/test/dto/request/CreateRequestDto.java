package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequestDto {

    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;

    public Request toEntity(CreateRequestDto createRequestDto) {
        Request request = new Request();
        request.setTestTitle(createRequestDto.getTestTitle());
        request.setSampleName(createRequestDto.getSampleName());
        request.setSampleQuantity(createRequestDto.getSampleQuantity());
        return request;
    }


}
