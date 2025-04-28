package lims.api.approve.controller;

import lims.api.approve.dto.request.ApproveRequestDto;
import lims.api.approve.dto.request.RejectRequestDto;
import lims.api.approve.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {
    private final ApprovalService approvalService;

    @PutMapping("/{id}/approve")
    public void approve(@PathVariable Long id, @RequestBody ApproveRequestDto approveRequestDto) {
        approvalService.approve(id, approveRequestDto);
    }

    @PutMapping("/{id}/reject")
    public void reject(@PathVariable Long id, @RequestBody RejectRequestDto rejectRequestDto) {
        approvalService.reject(id, rejectRequestDto);
    }






}
