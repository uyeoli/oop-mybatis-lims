package lims.api.approve.repository;

import lims.api.approve.entity.Approval;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprovalRepository {
    void insertApproval(Approval approval);
}
