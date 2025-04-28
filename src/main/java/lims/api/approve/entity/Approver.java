package lims.api.approve.entity;

import lims.api.approve.enums.ApproverType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Approver {
    private Long id;
    private Long approveId;
    private String approverName;
    private ApproverType approverType;

    public void approve() {
        this.approverType = ApproverType.APPROVE;
    }

    public void reject() {
        this.approverType = ApproverType.REJECT;
    }

    public boolean isApproved() {
        return this.approverType == ApproverType.APPROVE;
    }

}
