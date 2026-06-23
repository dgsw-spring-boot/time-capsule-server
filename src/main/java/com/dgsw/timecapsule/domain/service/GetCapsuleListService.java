package com.dgsw.timecapsule.domain.service;

import com.dgsw.timecapsule.domain.dto.GetCapsuleListResponse;
import com.dgsw.timecapsule.domain.repository.TimeCapsuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCapsuleListService {
    private final TimeCapsuleRepository timeCapsuleRepository;

    public List<GetCapsuleListResponse> getCapsuleList() {
        return timeCapsuleRepository.findAll()
                .stream()
                .map(GetCapsuleListResponse::from)
                .toList();
    }
}
