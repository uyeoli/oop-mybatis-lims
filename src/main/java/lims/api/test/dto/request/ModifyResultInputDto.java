package lims.api.test.dto.request;

import lims.api.test.entity.ResultInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ModifyResultInputDto {
    private Long id;
    private List<ModifyTestItemResultDto> testItemResults = new ArrayList<>();

    public ResultInput toResultInputEntity(ModifyResultInputDto modifyResultInputDto) {
        ResultInput resultInput = new ResultInput();
        resultInput.setReceiptId(modifyResultInputDto.getId());
        return resultInput;
    }
}
