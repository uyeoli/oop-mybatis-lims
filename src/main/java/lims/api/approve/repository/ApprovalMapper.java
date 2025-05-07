package lims.api.approve.repository;

import lims.api.approve.entity.Approval;
import lims.api.approve.entity.Approver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalMapper {
    void insert(Approval approval);

    List<Approver> findApprovers(Long approveId);

    Approval findById(Long id);

    void save(Approval approval);
}
