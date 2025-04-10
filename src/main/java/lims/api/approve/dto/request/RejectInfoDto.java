package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;

public class RejectInfoDto {
    private Long id;
    private String approverName;


    public static Approver of(RejectInfoDto rejectInfoDto) {
        return Approver.builder()
                .id(rejectInfoDto.id)
                .approverName(rejectInfoDto.approverName)
                .build();
    }
}
