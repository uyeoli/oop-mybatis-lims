package lims.api.approve.vo;

import lims.api.common.enums.UseType;
import lombok.Getter;

@Getter
public class DraftedApprover extends ApprovalParticipant {

    public DraftedApprover(String name) {
        super(name, UseType.N);
    }


}
