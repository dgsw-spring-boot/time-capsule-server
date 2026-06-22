package com.dgsw.timecapsule.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCapsuleRequest {
    private String title;
    private String content;
    private LocalDateTime openAt;
    @JsonProperty("isPublic")
    private boolean isPublic;
}
