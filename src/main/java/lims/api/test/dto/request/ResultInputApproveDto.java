package lims.api.test.dto.request;

import lims.api.approve.entity.Approver;
import lims.api.approve.vo.ApprovalParticipant;
import lims.api.approve.vo.DraftedApprover;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultInputApproveDto {
    private DraftedApprover draftedApprover;

    public ApprovalParticipant of() {
        return this.draftedApprover;
    }

}
