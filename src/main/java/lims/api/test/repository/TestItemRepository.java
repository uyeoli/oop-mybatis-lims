package lims.api.test.repository;

import lims.api.test.entity.TestItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestItemRepository {
    List<TestItem> findItems(Long id);

    void save(TestItem testItem);

    void delete(Long id);

    void deleteByReceiptId(Long id);
}
