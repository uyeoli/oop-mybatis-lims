package lims.api.test.controller;


import lims.api.test.dto.request.ReceiptInfoDto;
import lims.api.test.dto.response.ReceiptDto;
import lims.api.test.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/receipts")
@RequiredArgsConstructor
public class ReceiptController {
    private final ReceiptService receiptService;
    @GetMapping
    public ResponseEntity<List<ReceiptDto>> findAll() {
        return ResponseEntity.ok(receiptService.findAll());
    }

    @PostMapping
    public void receipt(ReceiptInfoDto receiptInfoDto) {
        receiptService.receipt(receiptInfoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        receiptService.delete(id);
    }





}
