package com.dgsw.timecapsule.domain.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateTimeCapsuleRequest {
    private String title;
    private String content;
    private LocalDateTime openAt;
    private Boolean isPublic;
}
