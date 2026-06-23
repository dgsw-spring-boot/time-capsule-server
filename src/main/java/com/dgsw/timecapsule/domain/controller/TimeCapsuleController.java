package com.dgsw.timecapsule.domain.controller;

import com.dgsw.timecapsule.domain.dto.*;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.service.*;
import com.dgsw.timecapsule.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timecapsule")
@RequiredArgsConstructor
public class TimeCapsuleController {
    private final GetTimeCapsuleService getTimeCapsuleService;
    private final UpdateTimeCapsuleService updateTimeCapsuleService;
    private final CreateCapsuleService createCapsuleService;
    private final GetCapsuleListService getCapsuleListService;
    private final DeleteCapsuleService deleteCapsuleService;

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
        return ApiResponse.ok(createCapsuleService.createCapsule(request));
    }

    @GetMapping("/capsules")
    public ApiResponse<List<GetCapsuleListResponse>> getCapsuleList() {
        return ApiResponse.ok(getCapsuleListService.getCapsuleList());
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCapsule(@PathVariable Long id) {
        deleteCapsuleService.deleteCapsule(id);
        return ApiResponse.ok(null);
    }
}
