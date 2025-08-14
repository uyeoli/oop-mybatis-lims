package lims.api.test.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lims.api.test.entity.Request;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@Tag(name = "request dto 객체")
public class RequestDto {

    private Long id;
    @Schema(title = "시험 제목", description = "시험 제목")
    private String testTitle;
    @Schema(title = "샘플명", description = "시험에 사용될 샘플 명")
    private String sampleName;
    @Schema(title = "샘플량", description = "시험에 사용될 샘플 량")
    private Integer sampleQuantity;
    @Schema(title = "의뢰 일자", description = "의뢰 일자")
    private LocalDate requestDate;

    public static RequestDto of(Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .testTitle(request.getTestTitle())
                .sampleName(request.getSampleName())
                .sampleQuantity(request.getSampleQuantity())
                .requestDate(request.getRequestDate())
                .build();
    }

}
