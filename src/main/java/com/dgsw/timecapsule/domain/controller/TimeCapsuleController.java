package com.dgsw.timecapsule.domain.controller;

import com.dgsw.timecapsule.domain.dto.CapsuleRequestDTO;
import com.dgsw.timecapsule.domain.dto.CapsuleResponseDTO;
import com.dgsw.timecapsule.domain.service.CapsuleService;
import com.dgsw.timecapsule.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timecapsule")
@RequiredArgsConstructor
public class TimeCapsuleController {
    private final CapsuleService capsuleService;

    @PostMapping("/capsule")
    public ApiResponse<CapsuleResponseDTO> createCapsule(@RequestBody CapsuleRequestDTO request) {
        return ApiResponse.ok(capsuleService.createCapsule(request));
    }
}
