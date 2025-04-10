package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyRequestDto {

    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;

    public Request toEntity(ModifyRequestDto modifyRequestDto) {
        Request request = new Request();
        request.setTestTitle(modifyRequestDto.getTestTitle());
        request.setSampleName(modifyRequestDto.getSampleName());
        request.setSampleQuantity(modifyRequestDto.getSampleQuantity());
        return request;
    }


}
