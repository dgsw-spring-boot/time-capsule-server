package com.dgsw.timecapsule.domain.dto;

import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UpdateTimeCapsuleResponse {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime openAt;
    private Boolean isPublic;

    public static UpdateTimeCapsuleResponse to(TimeCapsule timeCapsule) {
        return new UpdateTimeCapsuleResponse(
                timeCapsule.getId(),
                timeCapsule.getTitle(),
                timeCapsule.getCreatedAt(),
                timeCapsule.getUpdatedAt(),
                timeCapsule.getOpenAt(),
                timeCapsule.getIsPublic()
        );
    }
}
