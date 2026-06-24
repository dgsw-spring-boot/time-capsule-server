package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCapsuleService {
    private final TimeCapsuleRepository timeCapsuleRepository;

    public void deleteCapsule(Long id) {
        if(!timeCapsuleRepository.existsById(id)) {
            throw new RuntimeException("존재하지 않는 캡슐입니다.");
        }
        timeCapsuleRepository.deleteById(id);
    }
}
