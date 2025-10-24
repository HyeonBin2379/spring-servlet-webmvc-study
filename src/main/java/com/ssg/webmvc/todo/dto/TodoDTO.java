package com.ssg.webmvc.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
    DTO 용도
    - 여러 개의 데이터를 묶어서 1개의 객체로 구성
    - 서비스 객체의 메서드들의 파라미터나 리턴 타입으로 활용
 */
@Data   // getter, setter, toString, equals, hashCode 기능 모두 포함
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long tno;               // 할일 고유값 -> pk
    private String title;           // 할 일 제목
    private LocalDate dueDate;  // 등록 시간
    private boolean finished;       // 할 일 체크
}
