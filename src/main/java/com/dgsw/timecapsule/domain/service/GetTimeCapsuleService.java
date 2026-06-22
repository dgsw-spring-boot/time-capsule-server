package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import com.dgsw.timecapsule.global.exception.CustomException;
import com.dgsw.timecapsule.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetTimeCapsuleService {
    private final TimeCapsuleRepository timeCapsuleRepository;

    @Transactional
    public TimeCapsule execute(Long id) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        LocalDateTime now = LocalDateTime.now();

        if (timeCapsule.getOpenAt().isAfter(now)) {
            throw new CustomException(ErrorCode.FORBIDDEN);
        }

        return timeCapsule;
    }
}
