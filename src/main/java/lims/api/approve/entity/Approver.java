package lims.api.approve.entity;

import lims.api.approve.enums.ApproverType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Approver {
    private Long id;
    private Long approveId;
    private String approverName;
    private ApproverType approverType;

}
