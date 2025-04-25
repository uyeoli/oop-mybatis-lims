package lims.api.test.dto.request;

import lims.api.approve.vo.DraftedApprover;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReceiptApproveDto {

    private DraftedApprover draftedApprover;

    public DraftedApprover of() {
        return this.draftedApprover;
    }

}
