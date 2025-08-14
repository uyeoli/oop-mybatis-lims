package lims.api.test.dto.request;

import lims.api.test.entity.ResultInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultInputCreateDto {

    private Long receiptId;
    private List<TestItemResultCreateDto> testItemResults = new ArrayList<>();

    public ResultInput toResultInputEntity(ResultInputCreateDto resultInputCreateDto) {
        ResultInput resultInput = new ResultInput();
        resultInput.setReceiptId(resultInputCreateDto.getReceiptId());
        return resultInput;
    }

}
