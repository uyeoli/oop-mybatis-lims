package lims.api.test.controller;


import lims.api.test.dto.request.CreateRequestDto;
import lims.api.test.dto.request.ModifyRequestDto;
import lims.api.test.dto.response.RequestDto;
import lims.api.test.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {


    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<RequestDto>> findAll() {
        return ResponseEntity.ok(requestService.findAll());
    }

    @PostMapping
    public void create(@RequestBody CreateRequestDto createRequestDto) {
        requestService.create(createRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ModifyRequestDto modifyRequestDto) {
        requestService.update(id, modifyRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        requestService.delete(id);
    }



}
