package com.waffle.waffle.controller;

import com.waffle.waffle.domain.DTO.LoginDTO;
import com.waffle.waffle.domain.DTO.TokenDTO;
import com.waffle.waffle.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 로그인, id와 pw가 저장된 request body를 자바 객체로 변환하고 로그인 과정에 사용
    @PostMapping("/login")
    // @RequestBody: HTTP Request Body 내용을 통째로 자바 객체로 변환해서 매핑된 메소드 파라미터로 전달
    public TokenDTO login(@RequestBody LoginDTO memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        TokenDTO tokenDTO = memberService.login(memberId, password);
        return tokenDTO;
    }

    // 메인 페이지
    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("메인 페이지");
    }

    // 관리자 전용 페이지
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("관리자 페이지");
    }

    // 멤버 전용 페이지
    @GetMapping("/member")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("멤버 페이지");
    }

}