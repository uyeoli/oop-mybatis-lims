package lims.api.approve.entity;

import lims.api.common.enums.UseType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Approver {
    private Long id;
    private String approverName;
    private Integer approveOrder;
    private Long approveId;
    private UseType approveYn;
}
