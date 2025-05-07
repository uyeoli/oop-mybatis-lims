package lims.api.approve.entity;

import lims.api.approve.dto.request.ApprovalRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.enums.ApprovalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Getter
@Setter
public class Approval{
    private Long id;
    private LocalDate approveRequestDate;
    private ApprovalStatus approvalStatus;
    private List<Approver> approvers;

    public Approval(List<Approver> approvers) {
        this.approvers = approvers;
        this.approveRequestDate = LocalDate.now();
        this.approvalStatus = ApprovalStatus.DRAFT;
    }

    public void complete() {
        this.approvalStatus = ApprovalStatus.APPROVE_COMPLETE;
    }

    public void reject(RejectRequestDto rejectRequestDto) {
        Approver companion = rejectRequestDto.toEntity();

        this.approvalStatus = ApprovalStatus.REJECT;
    }

    public boolean isAllApproved() {
        return this.approvers.stream()
                .allMatch(approver -> approver.isApproved());
    }

    public Approver getCurrentApprover(ApprovalRequestDto approvalRequestDto) {
        Approver requestApprover = approvalRequestDto.toEntity();

        Optional<Approver> currentApprover = this.approvers.stream()
                .filter(approver -> approver.equals(requestApprover))
                .findAny();

        return currentApprover.orElseThrow(() -> new NoSuchElementException("Approver not found"));
    }

    public Approver getCompanion(RejectRequestDto rejectRequestDto) {
        Approver companion =
    }


}
