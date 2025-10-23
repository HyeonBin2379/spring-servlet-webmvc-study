package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dto.TodoDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
    enum 타입 클래스 사용의 장점
    - 생성할 객체의 개수를 제한할 수 있음 -> 객체를 1개만 생성해서 사용 가능(-> 싱글톤 패턴)
 */
public enum TodoService {

    /*
    - 생성할 서비스 객체의 개수를 제한하기 위한 enum
    - 현재 INSTANCE가 1개이므로 서비스는 1개만 운영
    - 사용 방법: TodoService.INSTANCE
    - 여러 컨트롤러들이 1개의 동일한 TodoService 객체와 원하는 데이터를 주고받는 구조로 구성
    */
    INSTANCE;

    public void register(TodoDTO todoDTO) {

    }

    // 10개의 todoDTO를 반환
    public List<TodoDTO> getList() {
        return LongStream.range(0, 10)
                .mapToObj(tno -> {
                    TodoDTO dto = new TodoDTO();
                    dto.setTno(tno);
                    dto.setTitle("Todo..title" + tno);
                    dto.setDueDate(LocalDateTime.now());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
