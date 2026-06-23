package com.dgsw.timecapsule.domain.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCapsuleRequest {
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @NotNull(message = "개봉일은 필수입니다.")
    @FutureOrPresent(message = "개봉일은 오늘 이후여야 합니다.")
    private LocalDateTime openAt;

    @NotNull
    private Boolean isPublic;
}
