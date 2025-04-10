package lims.api.test.dto.request;

import lims.api.approve.entity.Approver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultInputApproveDto {
    private String approverName;
    private Integer approveOrder;

    public static Approver of(ResultInputApproveDto resultInputApproveDto) {
        return Approver.builder()
                .approverName(resultInputApproveDto.getApproverName())
                .approveOrder(resultInputApproveDto.getApproveOrder())
                .build();
    }

}
