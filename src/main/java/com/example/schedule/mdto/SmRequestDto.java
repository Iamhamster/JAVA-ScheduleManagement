package com.example.schedule.mdto;

import lombok.Getter;

//데이터 트렌스폴 오브젝트 = DTO
//생성할 내용을 넣어주는 것(클라이언트가 사용)
@Getter
public class SmRequestDto {
    private String name;
    private String pw;
    private String todo;


}
