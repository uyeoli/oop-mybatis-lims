package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.vo.Companion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectInfoDto {
    private Long approveId;
    private Companion companion;


    public static Approver of(RejectInfoDto rejectInfoDto) {
        return Approver.builder()
                .id(rejectInfoDto.approveId)
                .approverName(rejectInfoDto.companion.getName())
                .build();
    }
}
