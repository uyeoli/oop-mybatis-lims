package lims.api.approve.vo;

import lims.api.approve.enums.ApproverType;
import lombok.Getter;

@Getter
public class DraftedApprover extends ApprovalParticipant {

    public DraftedApprover(String name) {
        super(name, ApproverType.DRAFTED);
    }


}
