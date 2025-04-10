package lims.api.test.dto.request;

import lims.api.test.entity.ResultInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateResultInputDto {

    private Long receiptId;
    private List<CreateTestItemResultDto> testItemResults = new ArrayList<>();

    public ResultInput toResultInputEntity(CreateResultInputDto createResultInputDto) {
        ResultInput resultInput = new ResultInput();
        resultInput.setReceiptId(createResultInputDto.getReceiptId());
        return resultInput;
    }

}
