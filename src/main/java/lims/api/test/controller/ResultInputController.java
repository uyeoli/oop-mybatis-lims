package lims.api.test.controller;

import lims.api.test.dto.request.ResultInputInfoDto;
import lims.api.test.dto.response.ResultInputDto;
import lims.api.test.service.ResultInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultInputController {
    private final ResultInputService resultInputService;

    @GetMapping
    public ResponseEntity<List<ResultInputDto>> findAll() {
        return ResponseEntity.ok(resultInputService.findAll());
    }

    @PostMapping
    public void save(ResultInputInfoDto resultInputInfoDto) {
        resultInputService.save(resultInputInfoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resultInputService.delete(id);
    }


}
