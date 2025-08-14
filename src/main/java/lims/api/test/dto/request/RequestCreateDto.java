package lims.api.test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lims.api.test.entity.Request;
import lims.api.test.enums.TestStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Tag(name = "request 생성 객체")
public class RequestCreateDto {


    @Schema(title = "시험 제목", description = "시험 제목")
    private String testTitle;
    @Schema(title = "샘플명", description = "시험에 사용될 샘플 명")
    private String sampleName;
    @Schema(title = "샘플량", description = "시험에 사용될 샘플 량")
    private Integer sampleQuantity;
    @Schema(title = "의뢰 일자", description = "의뢰 일자")
    private LocalDate requestDate;
    private final TestStatus testStatus = TestStatus.REQUEST_TEMPORARY_SAVE;

    public Request toEntity() {
        Request request = new Request();
        request.setTestTitle(this.getTestTitle());
        request.setSampleName(this.getSampleName());
        request.setSampleQuantity(this.getSampleQuantity());
        request.setTestStatus(this.testStatus);
        return request;
    }


}
