package com.waffle.waffle.service;

import com.waffle.waffle.domain.DTO.FineDTO;
import com.waffle.waffle.domain.Fine;
import com.waffle.waffle.repository.FineRepository;
import com.waffle.waffle.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FineService {

    private final FineRepository fineRepository;
    private final MemberRepository memberRepository;

    // 내역 추가
    public void addFine(FineDTO fineRequestDto) {
        // Member 객체를 가져와서 fineRequestDto 여기에 추가
        String username = fineRequestDto.getMemberId();
        fineRequestDto.setMember(memberRepository.findByMemberId(username).get());
        fineRepository.save(fineRequestDto.toEntity());
    }

    public List<FineDTO> fineList() {
        return fineRepository.findAll().stream()
                .map(Fine::toDTO)
                .collect(Collectors.toList());
    }

    public List<FineDTO> findByMemberId(String memberId) {
        return fineRepository.findFinesByMember(memberRepository.findByMemberId(memberId).get()).stream()
                .map(Fine::toDTO)
                .collect(Collectors.toList());
    }

}
