package com.waffle.waffle.domain;

import com.waffle.waffle.domain.DTO.FineDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

// 벌금 내역 저장
@Getter
@Table(name = "fine")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fine {

    // 아이디 자동 생성 (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;

    // 멤버 (FK)
    // N : 1 (fine : member)
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // join 조건
    private Member member;

    // 날짜
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    // 벌금을 내는 이유 (00: 지각, 01: 결석, 10: 미제출)
    @Column(nullable = false)
    private String type;

    // 벌금 납부 상태 (true: 납부, false: 미납)
    @Column(columnDefinition = "boolean default false")
    private Boolean status;

    // status 설정
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public FineDTO toDTO() {
        return FineDTO.builder()
                .id(id)
                .memberId(member.getMemberId())
                .date(date)
                .type(type)
                .status(status)
                .build();
    }

}
