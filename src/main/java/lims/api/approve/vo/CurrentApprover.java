package lims.api.approve.vo;

import lims.api.common.enums.UseType;
import lombok.Getter;

@Getter
public class CurrentApprover extends ApprovalParticipant{

    public CurrentApprover(String name) {
        super(name, UseType.Y);
    }
}

