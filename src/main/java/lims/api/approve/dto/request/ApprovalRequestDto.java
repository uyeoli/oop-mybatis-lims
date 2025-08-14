package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproveYn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovalRequestDto{

    private Long approverId;
    private String approverName;
    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setId(this.approverId);
        approver.setApproverName(this.approverName);
        approver.setApproveYn(ApproveYn.N);
        return approver;
    }

}
