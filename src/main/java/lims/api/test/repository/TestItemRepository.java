package lims.api.test.repository;

import lims.api.test.entity.TestItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TestItemRepository extends DataAccessRepository<TestItem, Long> {

    void deleteByReceiptId(Long id);

    List<TestItem> findItems(Long receiptId);
}
