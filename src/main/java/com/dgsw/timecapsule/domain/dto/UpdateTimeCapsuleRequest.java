package com.dgsw.timecapsule.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateTimeCapsuleRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime openAt;
    @NotNull
    private Boolean isPublic;
}
