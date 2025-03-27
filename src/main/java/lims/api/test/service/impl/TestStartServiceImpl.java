package lims.api.test.service.impl;

import lims.api.test.dto.request.TestStartRequestDto;
import lims.api.test.dto.TestStartFileDto;
import lims.api.test.dto.response.TestStartResponseDto;
import lims.api.test.entity.TestStart;
import lims.api.test.repository.TestStartRepository;
import lims.api.test.service.TestStartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestStartServiceImpl implements TestStartService {
    private final TestStartRepository testStartRepository;

    @Override
    public List<TestStartResponseDto> findAll() {
        return testStartRepository.findAll().stream().map(TestStart::of).collect(Collectors.toList());
    }

    @Override
    public TestStartResponseDto findById(String id) {
        return TestStart.of(testStartRepository.findById(id));
    }

    @Override
    public void save(TestStartRequestDto testStartRequestDto) {
        TestStart testStart = testStartRequestDto.toEntity(testStartRequestDto);
        testStartRepository.save(testStart);
    }

    @Override
    public void start(TestStartRequestDto testStartRequestDto) {
        TestStart testStart = testStartRequestDto.toEntity(testStartRequestDto);
        testStartRepository.start(testStart);
    }

    @Override
    public void saveFile(TestStartFileDto testStartFileDto) {

    }


}
