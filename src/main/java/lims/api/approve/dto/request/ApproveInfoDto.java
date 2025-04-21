package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.vo.CurrentApprover;
import lims.api.common.enums.UseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproveInfoDto {
    private Long id;
    private CurrentApprover currentApprover;

    public static Approver of(ApproveInfoDto approveInfoDto) {
        return Approver.builder()
                .id(approveInfoDto.id)
                .approverName(approveInfoDto.currentApprover.getName())
                .approveYn(UseType.Y)
                .build();
    }
}
