package com.ssg.webmvc.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

// DB 연동 작업 순서: 테이블 생성 -> VO 생성 -> DB 연결
// VO(Value Object): DB로부터 가져오는 원본 데이터 -> 읽기 전용(getter만 사용)
// 객체 생성 시 빌더패턴을 사용하기 위해 @Builder 사용
@Getter
@Builder
@ToString   // 객체에 저장된 값 확인용
public class TodoVO {

    private Long tno;
    private String title;
    private String content;
    private LocalDate dueDate;
    private boolean finished;
}
