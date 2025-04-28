package lims.api.approve.repository;

import lims.api.approve.entity.Approver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApproverRepository {

    void insert(Approver approver);
    void save(Approver approver);

}
