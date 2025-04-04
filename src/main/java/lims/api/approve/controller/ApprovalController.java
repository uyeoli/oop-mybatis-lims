package lims.api.approve.controller;

import lims.api.approve.dto.request.ApproveInfoDto;
import lims.api.approve.dto.request.RejectInfoDto;
import lims.api.approve.dto.response.ApproveDto;
import lims.api.approve.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {
    private final ApprovalService approvalService;
    @PostMapping
    public void approve(@RequestBody ApproveInfoDto approveInfoDto) {
        approvalService.approve(approveInfoDto);
    }

    @PutMapping
    public void reject(@RequestBody RejectInfoDto rejectInfoDto) {
        approvalService.reject(rejectInfoDto);
    }






}
