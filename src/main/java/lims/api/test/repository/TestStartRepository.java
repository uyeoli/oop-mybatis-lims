package lims.api.test.repository;

import lims.api.test.dto.TestStartFileDto;
import lims.api.test.entity.TestStart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestStartRepository {

    void save(TestStart testStart);
    void start(TestStart testStart);
    void saveFile(TestStartFileDto testStartFileDto);
    List<TestStart> findAll();

    TestStart findById(String id);
}
