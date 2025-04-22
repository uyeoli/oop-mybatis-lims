package lims.api.approve.vo;

import lims.api.approve.entity.Approver;
import lims.api.approve.enums.ApproverType;

public abstract class ApprovalParticipant {
    private final String name;
    private final ApproverType approverType;

    protected ApprovalParticipant(String name, ApproverType approverType) {
        this.name = name;
        this.approverType = approverType;
    }

    public String getName() {
        return name;
    }

    public ApproverType getApproverType() {
        return approverType;
    }

    public Approver toEntity() {
        return Approver.builder()
                .approverName(this.getName())
                .approverType(this.getApproverType())
                .build();
    }
}
