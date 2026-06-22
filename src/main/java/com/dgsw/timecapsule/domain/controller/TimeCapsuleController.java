package com.dgsw.timecapsule.domain.controller;

import com.dgsw.timecapsule.domain.dto.CreateCapsuleRequest;
import com.dgsw.timecapsule.domain.dto.CreateCapsuleResponse;
import com.dgsw.timecapsule.domain.dto.GetTimeCapsuleResponse;
import com.dgsw.timecapsule.domain.dto.UpdateTimeCapsuleRequest;
import com.dgsw.timecapsule.domain.dto.UpdateTimeCapsuleResponse;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.service.CapsuleService;
import com.dgsw.timecapsule.domain.service.GetTimeCapsuleService;
import com.dgsw.timecapsule.domain.service.UpdateTimeCapsuleService;
import com.dgsw.timecapsule.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timecapsule")
@RequiredArgsConstructor
public class TimeCapsuleController {
    private final GetTimeCapsuleService getTimeCapsuleService;
    private final UpdateTimeCapsuleService updateTimeCapsuleService;
    private final CapsuleService capsuleService;

    @GetMapping("/{id}")
    public ApiResponse<GetTimeCapsuleResponse> findById(@RequestParam Long id) {
        TimeCapsule timeCapsule = getTimeCapsuleService.execute(id);
        return ApiResponse.ok(GetTimeCapsuleResponse.to(timeCapsule));
    }

    @PutMapping("/{id}")
    public ApiResponse<UpdateTimeCapsuleResponse> UpdateById(
            @RequestParam Long id,
            @RequestBody UpdateTimeCapsuleRequest request
    ) {
        TimeCapsule timeCapsule = updateTimeCapsuleService.execute(id, request);
        return ApiResponse.ok(UpdateTimeCapsuleResponse.to(timeCapsule));
    }

    @PostMapping("/capsule")
    public ApiResponse<CreateCapsuleResponse> createCapsule(@RequestBody CreateCapsuleRequest request) {
        return ApiResponse.ok(capsuleService.createCapsule(request));
    }
}
