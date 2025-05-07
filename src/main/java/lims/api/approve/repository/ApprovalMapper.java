package lims.api.approve.repository;

import lims.api.approve.entity.Approval;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprovalMapper {
    void insert(Approval approval);

    Approval findById(Long id);

    void save(Approval approval);
}
