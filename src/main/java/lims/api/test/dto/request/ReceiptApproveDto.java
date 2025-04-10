package lims.api.test.dto.request;

import lims.api.approve.entity.Approver;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReceiptApproveDto {

    private String approverName;
    private Integer approveOrder;


    public static Approver of(ReceiptApproveDto receiptApproveDto) {
        return Approver.builder()
                .approverName(receiptApproveDto.getApproverName())
                .approveOrder(receiptApproveDto.approveOrder)
                .build();
    }

}
