package lims.api.test.controller;


import lims.api.test.dto.TestStartFileDto;
import lims.api.test.dto.request.RequestInfoDto;
import lims.api.test.dto.response.RequestDto;
import lims.api.test.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/request")
@RequiredArgsConstructor
public class RequestController {


    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<RequestDto>> findAll() {
        return ResponseEntity.ok(requestService.findAll());
    }

    @PostMapping
    public void request(@RequestBody RequestInfoDto requestInfoDto) {
        requestService.request(requestInfoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        requestService.delete(id);
    }



}
