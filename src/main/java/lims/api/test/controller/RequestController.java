package lims.api.test.controller;


import lims.api.test.dto.request.RequestCreateDto;
import lims.api.test.dto.request.RequestModifyDto;
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

    @PostMapping()
    public void create(@RequestBody RequestCreateDto requestCreateDto) {
        requestService.create(requestCreateDto);
    }

    @PutMapping("/{id}/submit")
    public void submit(@PathVariable Long id) {
        requestService.submitRequest(id);
    }

    @PutMapping("/{id}")
    public void modify(@PathVariable Long id, @RequestBody RequestModifyDto requestModifyDto) {
        requestService.update(id, requestModifyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        requestService.delete(id);
    }



}
