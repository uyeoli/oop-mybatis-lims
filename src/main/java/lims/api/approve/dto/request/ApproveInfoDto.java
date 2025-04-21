package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.common.enums.UseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproveInfoDto {
    private Long id;
    private String approverName;

    public static Approver of(ApproveInfoDto approveInfoDto) {
        return Approver.builder()
                .id(approveInfoDto.id)
                .approverName(approveInfoDto.approverName)
                .approveYn(UseType.Y)
                .build();
    }
}
