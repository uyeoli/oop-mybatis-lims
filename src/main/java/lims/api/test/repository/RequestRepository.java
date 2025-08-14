package lims.api.test.repository;

import lims.api.test.entity.Request;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestRepository extends DataAccessRepository<Request, Long> {
    void save(Request request);

}
