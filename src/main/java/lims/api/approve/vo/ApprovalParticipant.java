package lims.api.approve.vo;

import lims.api.approve.entity.Approver;
import lims.api.common.enums.UseType;

public abstract class ApprovalParticipant {
    private final String name;
    private final UseType approveYn;

    protected ApprovalParticipant(String name, UseType approveYn) {
        this.name = name;
        this.approveYn = approveYn;
    }

    public String getName() {
        return name;
    }

    public UseType getApproveYn() {
        return approveYn;
    }

    public Approver toEntity() {
        return Approver.builder()
                .approverName(this.getName())
                .approveYn(this.getApproveYn())
                .build();
    }
}
