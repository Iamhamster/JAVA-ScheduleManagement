package com.example.schedule.controller;

import com.example.schedule.mdto.SmRequestDto;
import com.example.schedule.mdto.SmResponseDto;
import com.example.schedule.service.SmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class SmController {
    private final SmService smService;

    @PostMapping("/sm") //메모 생성
    public ResponseEntity<SmResponseDto> createMemo(@RequestBody SmRequestDto dto){
        LocalDateTime currentTime = LocalDateTime.now();//현재 Date Time으로 고정됨.
        return ResponseEntity.ok(smService.createSm(dto, currentTime));
    }


    @GetMapping("/sm") //모두 보여주기
    public ResponseEntity<List<SmResponseDto>> findAll(){
        return ResponseEntity.ok(smService.findAll());
    }

    @GetMapping("/sm/{id}") //id에 맞는 거 보여주기
    public ResponseEntity<SmResponseDto> findById(@PathVariable long id){
        return ResponseEntity.ok(smService.findById(id));
    }

    @PutMapping("/sm/{id}")
    public SmResponseDto update(@PathVariable Long id, @RequestBody SmRequestDto dto){
        LocalDateTime updateNow = LocalDateTime.now();
        return smService.update(id, dto, updateNow);
    }

    @DeleteMapping("/sm/{id}")
    public void delete(@PathVariable Long id, @RequestBody SmRequestDto dto){
        smService.deleteById(id, dto);
    }

}
