package lims.api.test.repository;

import lims.api.test.entity.Request;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestRepository {

    void save(Request request);

    void update(Request request);

    List<Request> findAll();

    void deleteById(Long id);

}
