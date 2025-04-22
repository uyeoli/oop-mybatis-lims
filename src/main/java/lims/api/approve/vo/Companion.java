package lims.api.approve.vo;

import lims.api.approve.enums.ApproverType;

public class Companion extends ApprovalParticipant{
    public Companion(String name) {
        super(name, ApproverType.REJECT);
    }
}
