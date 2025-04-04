package lims.api.approve.entity;

import lims.api.approve.enums.ApprovalRequestDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Approval{
    private Long id;
    private ApprovalRequestDomain requestDomain;
    public Approval(ApprovalRequestDomain requestDomain) {
        this.requestDomain = requestDomain;
    }
}
