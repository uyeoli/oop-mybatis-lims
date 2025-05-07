package lims.api.approve.vo;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproveYn;
import lombok.Getter;

@Getter
public class DraftedApprover {
    private String approverName;
    private final ApproveYn approveYn = ApproveYn.N;

    public DraftedApprover(String approverName) {
        this.approverName = approverName;
    }

    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setApproverName(this.approverName);
        approver.setApproveYn(this.approveYn);
        return approver;
    }


}
