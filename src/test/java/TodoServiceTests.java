import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception{
        TodoDTO dto = TodoDTO.builder()
                .title("Todo DTO title 1")
                .dueDate(LocalDate.now())
                .build();
        todoService.register(dto);
    }

    @Test
    public void testListAll() throws Exception {
        List<TodoDTO> dtoList = todoService.listAll();
        dtoList.forEach(log::info);
    }

    @Test
    public void testRead() throws Exception {
        TodoDTO dto = todoService.get(4L);
        log.info(dto);
    }

    @Test
    public void testUpdate() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(1L)
                .title("Todo DTO Update...")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoService.update(todoDTO);
    }

    @Test
    public void testDelete() throws Exception {
        todoService.delete(4L);
    }
}
