package com.waffle.waffle.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.waffle.domain.Fine;
import com.waffle.waffle.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

// 벌금 추가할 때 사용하는 객체
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FineDTO {
    private Long id;
    @JsonIgnore
    private Member member;

    private String memberId;
    private Date date;
    private String type;
    private Boolean status;

    // DTO 형태로 만들어 줌
    public Fine toEntity() {
        return Fine.builder()
                .id(id)
                .member(member)
                .date(date)
                .type(type)
                .status(status)
                .build();
    }
}
