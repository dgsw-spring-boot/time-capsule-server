package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.dto.UpdateTimeCapsuleRequest;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import com.dgsw.timecapsule.global.exception.CustomException;
import com.dgsw.timecapsule.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateTimeCapsuleService {
    private final TimeCapsuleRepository timeCapsuleRepository;

    @Transactional
    public TimeCapsule execute(Long id, UpdateTimeCapsuleRequest request) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        timeCapsule.update(request.getTitle(), request.getContent(), request.getOpenAt(), request.getIsPublic());

        return timeCapsule;
    }
}
