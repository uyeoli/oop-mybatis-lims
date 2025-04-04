package lims.api.test.dto.request;

import lims.api.approve.entity.Approver;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ReceiptApproverInfoDto {

    private String approverName;
    private Integer approveOrder;

    /*
    TODO - 매번 필요한곳에서 정적 팩토리 메서드로 승인자 엔티티를 생성해줘야할까?
    */
    public static Approver of(ReceiptApproverInfoDto receiptApproverInfoDto) {
        return Approver.builder()
                .approverName(receiptApproverInfoDto.getApproverName())
                .approveOrder(receiptApproverInfoDto.approveOrder)
                .build();
    }

}
