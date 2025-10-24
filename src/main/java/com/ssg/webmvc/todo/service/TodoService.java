package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
    enum 타입 클래스 사용의 장점
    - 생성할 객체의 개수를 제한할 수 있음 -> 객체를 1개만 생성해서 사용 가능(-> 싱글톤 패턴)
 */
@Log4j2
public enum TodoService {

    /*
    - 생성할 서비스 객체의 개수를 제한하기 위한 enum
    - 현재 INSTANCE가 1개이므로 서비스는 1개만 운영
    - 사용 방법: TodoService.INSTANCE
    - 여러 컨트롤러들이 1개의 동일한 TodoService 객체와 원하는 데이터를 주고받는 구조로 구성
    */
    INSTANCE;

    private final TodoDAO dao;
    private final ModelMapper modelMapper;

    TodoService() {
        // IoC를 수행할 컨테이너가 없으므로, 사용자가 직접 필요한 객체를 주입하는 작업을 처리
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    /**
     * 컨트롤러로부터 TodoDTO 파라미터를 받아서 ModelMapper를 통해 todoVO 객체로 변환한 후
     * dao.insert()의 인자로 TodoVO 객체를 전달하여 등록 처리를 요청
     * @param todoDTO : 컨트롤러로부터 전달받은 todo 정보가 저장된 객체
     */
    public void register(TodoDTO todoDTO) throws Exception {
        // 리플렉션 기법 적용 -> TodoDTO 객체를 TodoVO로 변환
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//        System.out.println(todoVO);     // Log4j2를 사용하여 로그를 출력하도록 변경 예정
        log.info(todoVO);   // log4j2를 사용하여 로그 메시지를 출력
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAll();
        log.info("voList---------------------");
        log.info(voList);

        // List<TodoVO>를 List<TodoDTO>로 변경한 후 반환
        return voList.stream()
                .map(todoVO -> modelMapper.map(todoVO, TodoDTO.class))
                .collect(Collectors.toList());
    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(false);
        return dto;
    }
}
