package lims.api.test.dto.request;

import lims.api.test.entity.ResultInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultInputModifyDto {
    private Long id;
    private List<TestItemResultModifyDto> testItemResults = new ArrayList<>();

    public ResultInput toResultInputEntity(ResultInputModifyDto resultInputModifyDto) {
        ResultInput resultInput = new ResultInput();
        resultInput.setReceiptId(resultInputModifyDto.getId());
        return resultInput;
    }
}
