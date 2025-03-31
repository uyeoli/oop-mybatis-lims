package lims.api.test.repository;

import lims.api.test.entity.Receipt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiptRepository extends DataAccessRepository<Receipt, Long> {

}
