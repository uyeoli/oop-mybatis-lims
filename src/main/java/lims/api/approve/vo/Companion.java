package lims.api.approve.vo;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproverType;
import lombok.Getter;

@Getter
public class Companion{
    private String approverName;
    private final ApproverType approverType = ApproverType.REJECT;

    public Companion(String approverName) {
        this.approverName = approverName;
    }

    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setApproverName(this.approverName);
        approver.setApproverType(this.approverType);
        return approver;
    }


}
