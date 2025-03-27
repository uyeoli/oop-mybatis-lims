package lims.api.test.service;

import lims.api.test.dto.request.TestStartRequestDto;
import lims.api.test.dto.TestStartFileDto;
import lims.api.test.dto.response.TestStartResponseDto;

import java.util.List;

public interface TestStartService {

    void save(TestStartRequestDto testRequestDto);
    void start(TestStartRequestDto testRequestDto);
    void saveFile(TestStartFileDto testStartFileDto);
    List<TestStartResponseDto> findAll();

    TestStartResponseDto findById(String id);
}
