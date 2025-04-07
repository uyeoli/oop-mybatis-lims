package lims.api.test.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultInputInfoDto {

    private Long id;
    private Long receiptId;
    private List<TestItemResultDto> testItemResultDto;
}
