package com.example.schedule.controller;

import com.example.schedule.mdto.smRequestDTO;
import com.example.schedule.mdto.smResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.schedule.entity.scheduleManagement;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/SMs")
public class smController {
    private final Map<Long, scheduleManagement> smList = new HashMap<>();

    @PostMapping
    public ResponseEntity<smResponseDTO> createSM(@RequestBody smRequestDTO dto){
        Long smId = smList.isEmpty() ? 1: Collections.max(smList.keySet())+1;                    //1++
        scheduleManagement sm = new scheduleManagement(smId, dto.getName(), dto.getPw(), dto.getTodo());

        smList.put(smId, sm);

        return new ResponseEntity<smResponseDTO>(new smResponseDTO(sm), HttpStatus.CREATED);    //생성합니다.
    }
}
