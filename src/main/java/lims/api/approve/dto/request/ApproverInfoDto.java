package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.vo.CurrentApprover;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproverInfoDto {
    private Long approverId;
    private CurrentApprover currentApprover;

    public static Approver of(ApproverInfoDto approverInfoDto) {
        return Approver.builder()
                .id(approverInfoDto.approverId)
                .approverName(approverInfoDto.currentApprover.getName())
                .approverType(approverInfoDto.currentApprover.getApproverType())
                .build();
    }
}
