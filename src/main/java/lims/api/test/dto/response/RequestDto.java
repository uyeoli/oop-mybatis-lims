package lims.api.test.dto.response;

import lims.api.test.entity.Request;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class RequestDto {

    private Long id;
    private String testTitle;
    private String sampleName;
    private Integer sampleQuantity;
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
