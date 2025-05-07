package lims.api.approve.controller;

import lims.api.approve.dto.request.ApprovalRequestDto;
import lims.api.approve.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {
    private final ApprovalService approvalService;

    @PutMapping("/{id}/approve")
    public void approve(@PathVariable Long id, @RequestBody ApprovalRequestDto approvalRequestDto) {
        approvalService.approve(id, approvalRequestDto);
    }

    @PutMapping("/{id}/reject")
    public void reject(@PathVariable Long id) {
        approvalService.reject(id);
    }






}
