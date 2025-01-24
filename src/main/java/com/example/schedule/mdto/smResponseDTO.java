package com.example.schedule.mdto;

import com.example.schedule.entity.scheduleManagement;
import lombok.Getter;

@Getter
public class smResponseDTO {
    private Long id;
    private String name;
    private String pw;
    private String todo;

    public smResponseDTO(scheduleManagement sm){
        this.id = sm.getId();
        this.name = sm.getName();
        this.pw = sm.getPw();
        this.todo = sm.getTodo();
    }
}
