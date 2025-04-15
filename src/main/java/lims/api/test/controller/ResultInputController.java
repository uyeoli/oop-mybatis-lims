package lims.api.test.controller;

import lims.api.test.dto.request.CreateResultInputDto;
import lims.api.test.dto.request.ModifyResultInputDto;
import lims.api.test.dto.request.ResultInputApproveDto;
import lims.api.test.dto.response.ResultInputDto;
import lims.api.test.service.ResultInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resultInputs")
public class ResultInputController {
    private final ResultInputService resultInputService;
    /*
    1. 결과입력할 시험을 조회한다. - findAll
    2. 시험항목에 대한 결과를 입력한다. - save
    3. 결과입력 승인을 요청한다. - draft
    4. 결과입력할 시험을 삭제한다.
     */

    @GetMapping
    public ResponseEntity<List<ResultInputDto>> findAll() {
        return ResponseEntity.ok(resultInputService.findAll());
    }

    @PostMapping
    public void create(@RequestBody CreateResultInputDto createResultInputDto) {
        resultInputService.create(createResultInputDto);
    }

    @PutMapping("/{id}")
    public void modify(@RequestBody ModifyResultInputDto modifyResultInputDto) {
        resultInputService.modify(modifyResultInputDto);
    }

    @PutMapping("/{id}/approval")
    public void draft(@PathVariable Long id, List<ResultInputApproveDto> resultInputApproveDto) {
        resultInputService.draft(id, resultInputApproveDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resultInputService.delete(id);
    }
}
