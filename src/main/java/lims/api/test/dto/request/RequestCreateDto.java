package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RequestCreateDto {

    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private LocalDate requestDate;

    public Request toEntity() {
        Request request = new Request();
        request.setTestTitle(this.getTestTitle());
        request.setSampleName(this.getSampleName());
        request.setSampleQuantity(this.getSampleQuantity());
        request.setRequestDate(this.requestDate);
        return request;
    }


}
