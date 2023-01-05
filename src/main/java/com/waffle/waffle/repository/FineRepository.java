package com.waffle.waffle.repository;

import com.waffle.waffle.domain.Fine;
import com.waffle.waffle.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FineRepository extends JpaRepository<Fine, Long> {

    // 멤버로 벌금 내역 찾기
    List<Fine> findFinesByMember(Member member);

}
