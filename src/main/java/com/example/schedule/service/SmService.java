package com.example.schedule.service;

import com.example.schedule.entity.ScheduleManagement;
import com.example.schedule.mdto.SmRequestDto;
import com.example.schedule.mdto.SmResponseDto;
import com.example.schedule.repository.SmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmService {

    private final SmRepository smRepository;

    @Transactional
    public SmResponseDto createSm(SmRequestDto dto, LocalDateTime currentTime) {
        ScheduleManagement sm = new ScheduleManagement(dto.getName(), dto.getPw(), dto.getTodo(), currentTime);     // <- id가 없는 memo
        ScheduleManagement savedSm = smRepository.save(sm); // <- id가 있는 memo

        return new SmResponseDto(savedSm.getId(), savedSm.getName(), savedSm.getTodo(), savedSm.getCreateTime(), savedSm.getUpdateTime());
    }

    @Transactional(readOnly = true)
    public List<SmResponseDto> findAll() {
        List<ScheduleManagement> sms = smRepository.findAll();
        List<SmResponseDto> dtoList = new ArrayList<>();
        for (ScheduleManagement sm : sms) {
            SmResponseDto dto = new SmResponseDto(sm.getId(), sm.getName(), sm.getTodo(), sm.getCreateTime(), sm.getUpdateTime());

            dtoList.add(dto);
        }
        return dtoList;
    }

    public SmResponseDto findById(long id) {
        ScheduleManagement sm = smRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메모가 존재하지 않습니다."));
        return new SmResponseDto(sm.getId(), sm.getName(), sm.getTodo(), sm.getCreateTime(), sm.getUpdateTime());
    }

    public SmResponseDto update(Long id, SmRequestDto dto, LocalDateTime updateNow) {
        //메모 유무 검사
        ScheduleManagement sm = smRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메모가 존재하지 않습니다."));

        if(!dto.getPw().equals(sm.getPw())){
            throw new RuntimeException();
        }

        //메모를 업데이트함 LocalDateTime updateTime
        ScheduleManagement updatedSm = smRepository.update(id, dto.getName(), dto.getTodo(), updateNow);
        //업데이트를 타입에 맞게 맞춰서 return함.
        return new SmResponseDto(updatedSm.getId(), updatedSm.getName(), updatedSm.getTodo(), updatedSm.getCreateTime(), updatedSm.getUpdateTime());
    }

    public void deleteById(Long id, SmRequestDto dto) {
        //메모 유무 검사
        ScheduleManagement sm = smRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메모가 존재하지 않습니다."));
        if(!dto.getPw().equals(sm.getPw())){
            throw new RuntimeException();
        }
        smRepository.deleteById(id);
    }
}
