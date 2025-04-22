package lims.api.approve.vo;

import lims.api.approve.enums.ApproverType;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CurrentApprover extends ApprovalParticipant{

    public CurrentApprover(String name) {
        super(name, ApproverType.APPROVE);
    }



}

