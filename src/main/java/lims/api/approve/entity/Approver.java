package lims.api.approve.entity;

import lims.api.approve.enums.ApproveYn;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Approver {
    private Long id;
    private Long approveId;
    private String approverName;
    private ApproveYn approveYn;

    public void approve() {
        this.approveYn = ApproveYn.Y;
    }

    public boolean isApproved() {
        return this.approveYn == ApproveYn.Y;
    }

}
