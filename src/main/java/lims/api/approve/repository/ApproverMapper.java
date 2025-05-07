package lims.api.approve.repository;

import lims.api.approve.entity.Approver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApproverMapper {

    void insert(Approver approver);
    void save(Approver approver);

    List<Approver> findByApprovalId(Long approvalId);
}
