package lims.api.approve.vo;

import lims.api.common.enums.UseType;

public class Companion extends ApprovalParticipant{
    public Companion(String name) {
        super(name, UseType.N);
    }
}
