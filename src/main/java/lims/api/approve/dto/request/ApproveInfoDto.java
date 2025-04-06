package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;

public class ApproveInfoDto {
    private Long id;
    private String approverName;
    private String domain;


    public static Approver of(ApproveInfoDto approveInfoDto) {
        return Approver.builder()
                .id(approveInfoDto.id)
                .approverName(approveInfoDto.approverName)
                .build();
    }
}
