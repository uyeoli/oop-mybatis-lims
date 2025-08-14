package lims.api.test.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lims.api.test.dto.request.ReceiptModifyDto;
import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.ReceiptCreateDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "receipt controller api", description = "접수 API")
@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    @GetMapping
    public ResponseEntity<List<ReceiptDto>> findAll() {
        return ResponseEntity.ok(receiptService.findAll());
    }

    @PostMapping
    public void create(@RequestBody ReceiptCreateDto receiptCreateDto) {
        receiptService.insert(receiptCreateDto);
    }

    @PutMapping
    public void modify(Long id, @RequestBody ReceiptModifyDto receiptModifyDto) {
        receiptService.update(id, receiptModifyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        receiptService.delete(id);
    }

    @PutMapping("/{id}/approval")
    public void draft(@PathVariable Long id, @RequestBody List<ReceiptApproveDto> receiptApproveDto) {
        receiptService.draft(id, receiptApproveDto);
    }





}
