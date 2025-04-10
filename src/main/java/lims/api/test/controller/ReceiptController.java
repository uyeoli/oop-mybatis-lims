package lims.api.test.controller;


import lims.api.test.dto.request.ReceiptApproveDto;
import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void save(@RequestBody ReceiptInfoDto receiptInfoDto) {
        receiptService.save(receiptInfoDto);
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
