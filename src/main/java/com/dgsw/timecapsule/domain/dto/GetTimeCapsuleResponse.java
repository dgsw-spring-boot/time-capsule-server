package com.dgsw.timecapsule.domain.dto;

import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GetTimeCapsuleResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime openAt;
    private Boolean isPublic;

    public static GetTimeCapsuleResponse to(TimeCapsule timeCapsule) {
        return new GetTimeCapsuleResponse(
                timeCapsule.getId(),
                timeCapsule.getTitle(),
                timeCapsule.getContent(),
                timeCapsule.getCreatedAt(),
                timeCapsule.getUpdatedAt(),
                timeCapsule.getOpenAt(),
                timeCapsule.getIsPublic()
        );
    }
}
