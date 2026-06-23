package com.dgsw.timecapsule.domain.dto;

import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GetCapsuleListResponse {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime openAt;
    private Boolean isPublic;

    public static GetCapsuleListResponse from(TimeCapsule capsule) {
        return new GetCapsuleListResponse(
                capsule.getId(),
                capsule.getTitle(),
                capsule.getCreatedAt(),
                capsule.getUpdatedAt(),
                capsule.getOpenAt(),
                capsule.getIsPublic()
        );
    }
}
