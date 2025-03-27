package lims.api.test.controller;


import lims.api.test.dto.request.TestStartRequestDto;
import lims.api.test.dto.TestStartFileDto;
import lims.api.test.dto.response.TestStartResponseDto;
import lims.api.test.service.TestStartService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starts")
@RequiredArgsConstructor
public class TestStartController {

    private final TestStartService testStartService;

    @GetMapping
    public ResponseEntity<List<TestStartResponseDto>> findAll() {
        return ResponseEntity.ok(testStartService.findAll());
    }

    @PostMapping("/save")
    public void save(TestStartRequestDto testStartRequestDto) {
        testStartService.save(testStartRequestDto);
    }

    @PostMapping("/file")
    public void saveFile(TestStartFileDto testStartFileDto) {
        testStartService.saveFile(testStartFileDto);
    }

    @PostMapping
    public void start(TestStartRequestDto testStartRequestDto) {
        testStartService.start(testStartRequestDto);
    }



}
