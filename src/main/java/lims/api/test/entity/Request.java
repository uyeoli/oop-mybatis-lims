package lims.api.test.entity;

import lims.api.test.dto.request.RequestModifyDto;
import lims.api.test.enums.TestStatus;
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
    private TestStatus testStatus;

    public Request modify(RequestModifyDto requestModifyDto) {
        this.setTestTitle(requestModifyDto.getTestTitle());
        this.setSampleName(requestModifyDto.getSampleName());
        this.setSampleQuantity(requestModifyDto.getSampleQuantity());
        return this;
    }

    public void submit() {
        if(this.testStatus != TestStatus.REQUEST_TEMPORARY_SAVE) {
            throw new IllegalArgumentException("임시저장 상태에서만 의뢰할 수 있습니다.");
        }
        this.testStatus = TestStatus.REQUEST;
        this.requestDate = LocalDate.now();
    }




}
