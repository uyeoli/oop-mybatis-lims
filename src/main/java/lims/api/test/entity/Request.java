package lims.api.test.entity;

import lims.api.test.dto.request.RequestModifyDto;
import lims.api.test.dto.response.RequestDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Request {
    private Long id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private LocalDate requestDate;

    public Request updateFrom(RequestModifyDto requestModifyDto) {
        this.setTestTitle(requestModifyDto.getTestTitle());
        this.setSampleName(requestModifyDto.getSampleName());
        this.setSampleQuantity(requestModifyDto.getSampleQuantity());
        return this;
    }
}
