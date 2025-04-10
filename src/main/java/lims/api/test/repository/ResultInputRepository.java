package lims.api.test.repository;

import lims.api.test.entity.ResultInput;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResultInputRepository extends DataAccessRepository<ResultInput,Long>{

    void updateApproveKey(ResultInput resultInput);

}
