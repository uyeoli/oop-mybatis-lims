package lims.api.test.repository;

import lims.api.test.entity.TestItemResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestItemResultRepository extends DataAccessRepository<TestItemResult, Long>{
}
