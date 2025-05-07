package lims.api.approve.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproverType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectRequestDto{
    private Long approverId;

    public Approver toEntity() {
        Approver approver = new Approver();
        approver.setId(this.approverId);
        approver.setApproverType(ApproverType.REJECT);
        return approver;
    }
}
