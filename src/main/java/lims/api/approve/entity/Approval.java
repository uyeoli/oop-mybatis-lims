package lims.api.approve.entity;

import lims.api.approve.enums.ApprovalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Approval{
    private Long id;
    private LocalDate approveRequestDate;
    private ApprovalStatus approvalStatus;
    private List<Approver> approvers;

    public Approval(LocalDate approveRequestDate, ApprovalStatus approvalStatus) {
        this.approveRequestDate = approveRequestDate;
        this.approvalStatus = approvalStatus;
    }

    public void complete() {
        this.approvalStatus = ApprovalStatus.APPROVE_COMPLETE;
    }

    public void reject() {
        this.approvalStatus = ApprovalStatus.REJECT;
    }

}
