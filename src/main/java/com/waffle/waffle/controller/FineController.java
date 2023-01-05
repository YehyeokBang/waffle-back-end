package com.waffle.waffle.controller;

import com.waffle.waffle.domain.DTO.FineDTO;
import com.waffle.waffle.service.FineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FineController {

    private final FineService fineService;

    // 관리자 페이지에서 벌금 추가하기 RequestBody -> memberId(String), date(YYYY-MM-DD), type(00, 01, 10)
    @PostMapping("/admin/add")
    public ResponseEntity<String> adminAdd(@RequestBody FineDTO fineRequestDto) {
        fineService.addFine(fineRequestDto);
        return ResponseEntity.ok("add fine successfully");
    }

    // 관리자 페이지에서 전체 벌금 내역을 문자열로 출력
    /*
       쉽게 결과 확인하기
       String s = "";
        for(FineDTO f : response) {
            s += f.getMember().getMemberId() + " ";
            s += f.getDate().toString() + " ";
            s += f.getType() + " ";
            s += f.getStatus() + "\n";
        }
        return s;
    */
    @GetMapping("/admin/list")
    public ResponseEntity<List<FineDTO>>  adminList() {
        List<FineDTO> response = fineService.fineList();
        return ResponseEntity.ok(response);
    }

    // 관리자가 특정 멤버의 내역을 확인
    // ResponseEntity<List<FineDTO>>  ResponseEntity.ok(response);
    @GetMapping("/admin/{id}")
    public ResponseEntity<List<FineDTO>> findByMemberId(@PathVariable("id") String id) {
        List<FineDTO> response = fineService.findByMemberId(id);
        return ResponseEntity.ok(response);
    }
}