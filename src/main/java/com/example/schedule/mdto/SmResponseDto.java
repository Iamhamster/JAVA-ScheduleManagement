package com.example.schedule.mdto;

import com.example.schedule.entity.ScheduleManagement;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//생성 후, 보여주는 것(디스플레이)
@Getter
public class SmResponseDto {
    private Long id;
    private String name;
    private String todo;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;

    public SmResponseDto(Long id, String name, String todo, LocalDateTime createDateTime, LocalDateTime updateDateTime){
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
