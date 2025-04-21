package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectInfoDto {
    private Long approveId;
    private String approverName;


    public static Approver of(RejectInfoDto rejectInfoDto) {
        return Approver.builder()
                .id(rejectInfoDto.approveId)
                .approverName(rejectInfoDto.approverName)
                .build();
    }
}
