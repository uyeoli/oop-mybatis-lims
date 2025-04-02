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

    //1. 접수에 대한 결재 정보 조회

    //2. 결재 저장(요청)
    //요청을 보내는 클래스의 역할
    
    //3. 결재 상신
    //결재의 역할
    
    //4. 결재 반려
    //결재의 역할

    //결재 요청을 보내는 각각의 서비스에서 요청
    @PostMapping
    public void approve(@RequestBody ApproveInfoDto approveInfoDto) {
        approvalService.approve(approveInfoDto);
    }

    @PutMapping
    public void reject(@RequestBody RejectInfoDto rejectInfoDto) {
        approvalService.reject(rejectInfoDto);
    }






}
