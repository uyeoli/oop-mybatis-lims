package lims.api.approve.dto.request;

import lims.api.approve.vo.Companion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectRequestDto {
    private Long approveId;
    private Companion companion;
}
