package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproveYn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovalRequestDto{

    private Long approverId;
    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setId(this.approverId);
        approver.setApproveYn(ApproveYn.Y);
        return approver;
    }

}
