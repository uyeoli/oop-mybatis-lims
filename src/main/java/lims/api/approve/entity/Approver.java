package lims.api.approve.entity;

import lims.api.approve.enums.ApproveYn;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Approver {

    @EqualsAndHashCode.Include
    private Long id;
    private Long approvalId;
    private String approverName;
    private ApproveYn approveYn;

    public void approve() {
        this.approveYn = ApproveYn.Y;
    }

    public boolean isApproved() {
        return this.approveYn == ApproveYn.Y;
    }

}
