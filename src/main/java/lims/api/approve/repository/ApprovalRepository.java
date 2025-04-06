package lims.api.approve.repository;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprovalRepository {
    void insertApproval(Approval approval);

    void insertApprover(Approver approver);

    void approve(Approver approver);
    void reject(Approver approver);
}
