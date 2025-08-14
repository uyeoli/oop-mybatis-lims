package lims.api.test.dto.response;

import lims.api.test.dto.request.TestItemResultCreateDto;
import lims.api.test.entity.Receipt;
import lims.api.test.entity.ResultInput;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultInputDto {
    private Long id;
    private String testJudgement;
    private List<TestItemResultCreateDto> itemResult;

    public static ResultInputDto of(ResultInput resultInput) {
        ResultInputDto resultInputDto = new ResultInputDto();
        resultInputDto.setId(resultInput.getId());
        resultInputDto.setTestJudgement(resultInputDto.getTestJudgement());
        return resultInputDto;
    }

}
