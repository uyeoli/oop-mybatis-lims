package lims.api.test.repository;

import lims.api.test.entity.Receipt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiptRepository {

    List<Receipt> findAll();
    void save(Receipt receipt);
    void update(Receipt receipt);
    void deleteById(Long id);
}
