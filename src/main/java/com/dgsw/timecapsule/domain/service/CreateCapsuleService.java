package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.dto.CreateCapsuleResponse;
import com.dgsw.timecapsule.domain.dto.CreateCapsuleRequest;
import com.dgsw.timecapsule.domain.entity.TimeCapsule;
import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCapsuleService {
    private final TimeCapsuleRepository capsuleRepository;
    public CreateCapsuleResponse createCapsule(CreateCapsuleRequest request) {
        TimeCapsule timeCapsule = new TimeCapsule(null,
                request.getTitle(),
                request.getContent(),
                null,
                null,
                request.getOpenAt(),
                request.isPublic()
        );

        capsuleRepository.save(timeCapsule);

        return CreateCapsuleResponse.to(timeCapsule);
    }
}
