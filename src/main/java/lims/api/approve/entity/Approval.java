package lims.api.approve.entity;

import lims.api.approve.enums.ApprovalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Approval{
    private Long id;
    private LocalDate approveDate;
    private ApprovalStatus approvalStatus;

    public Approval(LocalDate approveDate, ApprovalStatus approvalStatus) {
        this.approveDate = approveDate;
        this.approvalStatus = approvalStatus;
    }

    public void complete() {
        this.approvalStatus = ApprovalStatus.APPROVE_COMPLETE;
    }

}
