package lims.api.approve.vo;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproverType;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CurrentApprover{
    private final String approverName;
    private final ApproverType approverType = ApproverType.APPROVE;

    public CurrentApprover(String approverName) {
        this.approverName = approverName;
    }

    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setApproverName(this.approverName);
        approver.setApproverType(this.approverType);
        return approver;
    }


}

