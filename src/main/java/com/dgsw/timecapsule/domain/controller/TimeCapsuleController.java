package com.dgsw.timecapsule.domain.controller;

import com.dgsw.timecapsule.domain.dto.GetTimeCapsuleResponse;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.service.GetTimeCapsuleService;
import com.dgsw.timecapsule.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timecapsule")
@RequiredArgsConstructor
public class TimeCapsuleController {
    private final GetTimeCapsuleService getTimeCapsuleService;

    @GetMapping("/{id}")
    public ApiResponse<GetTimeCapsuleResponse> findById(@RequestParam Long id) {
        TimeCapsule timeCapsule = getTimeCapsuleService.execute(id);
        return ApiResponse.ok(GetTimeCapsuleResponse.to(timeCapsule));
    }
}
