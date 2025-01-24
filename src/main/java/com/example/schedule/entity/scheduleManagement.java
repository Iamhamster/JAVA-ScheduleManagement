package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class scheduleManagement {
    //할일, 작성자명, 비밀번호, 작성/수정일
    private Long id;
    private String name;
    private String pw;
    private String todo;

    //private LocalDateTime startTime = LocalDateTime.now();

    //각 일정의 고유 식별자를 자동 생성, 관리

    //최초 입력 시, 수정일은 작성일과 동일
}
