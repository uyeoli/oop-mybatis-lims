package lims.api.test.dto.request;

import lims.api.test.entity.Request;
import lims.api.test.enums.TestStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class RequestCreateDto {

    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
    private LocalDate requestDate;
    private final TestStatus testStatus = TestStatus.TEMPORARY_SAVE;

    public Request toEntity() {
        Request request = new Request();
        request.setTestTitle(this.getTestTitle());
        request.setSampleName(this.getSampleName());
        request.setSampleQuantity(this.getSampleQuantity());
        request.setRequestDate(LocalDate.now());
        request.setTestStatus(this.testStatus);
        return request;
    }


}
