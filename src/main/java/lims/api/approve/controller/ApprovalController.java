package lims.api.approve.controller;

import lims.api.approve.dto.request.ApproveInfoDto;
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

    //1. 접수에 대한 결재 정보 조회
    
    //2. 모든 결재 조회
    
    //3. 결재 저장(요청)
    
    //4. 결재 상신
    
    //5. 결재 반려
    @GetMapping
    public ResponseEntity<List<ApproveDto>> findAll() {
        return ResponseEntity.ok(approvalService.findAll());
    }

    @PostMapping
    public void approve(@RequestBody ApproveInfoDto approveInfoDto) {
        approvalService.approve(approveInfoDto);
    }






}
