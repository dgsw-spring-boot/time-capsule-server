package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.dto.CapsuleResponseDTO;
import com.dgsw.timecapsule.domain.dto.CapsuleRequestDTO;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CapsuleService {
    private final TimeCapsuleRepository capsuleRepository;

    public CapsuleResponseDTO createCapsule(CapsuleRequestDTO request) {
        TimeCapsule timeCapsule = new TimeCapsule(null,
                request.getTitle(),
                request.getContent(),
                null,
                null,
                request.getOpenAt(),
                request.isPublic()
        );

        capsuleRepository.save(timeCapsule);

        return new CapsuleResponseDTO("타임캡슐 생성에 성공했습니다.");
    }
}
