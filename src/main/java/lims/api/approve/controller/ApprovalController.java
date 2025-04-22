package lims.api.approve.controller;

import lims.api.approve.dto.request.ApproverInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {
    private final ApprovalService approvalService;

    @PutMapping("/{id}/approve")
    public void approve(@PathVariable Long id, @RequestBody ApproverInfoDto approverInfoDto) {
        approvalService.approve(id, approverInfoDto);
    }

    @PutMapping("/{id}/reject")
    public void reject(@RequestBody RejectInfoDto rejectInfoDto) {
        approvalService.reject(rejectInfoDto);
    }






}
