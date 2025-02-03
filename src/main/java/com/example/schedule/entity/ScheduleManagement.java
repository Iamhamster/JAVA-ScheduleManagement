package com.example.schedule.entity;

import com.example.schedule.mdto.SmRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleManagement {
    //할일, 작성자명, 비밀번호, 작성/수정일
    @Setter
    private Long id; //식별자
    private String name; //작성자명
    private String pw; //비밀번호
    private String todo; //내용
    private LocalDateTime createTime; //작성일
    private LocalDateTime updateTime; //수정일


    public ScheduleManagement(SmRequestDto dto){
        this.name = dto.getName();
        this.pw = dto.getPw();
        this.todo = dto.getTodo();
    }

    public ScheduleManagement(String name, String pw, String todo, LocalDateTime currentTime) {
        this.name = name;
        this.pw = pw;
        this.todo = todo;
        this.createTime = currentTime;
        this.updateTime = currentTime;
    }


    public ScheduleManagement(long id, String name, String todo, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
