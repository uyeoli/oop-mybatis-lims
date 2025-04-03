package lims.api.approve.entity;

import lims.api.approve.enums.ApprovalRequestDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Approval{
    private Long id;
    private ApprovalRequestDomain approvalRequestDomain;

    public Approval(ApprovalRequestDomain approvalRequestDomain) {
        this.approvalRequestDomain = approvalRequestDomain;
    }
}
