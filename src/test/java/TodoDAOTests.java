import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    // 각각의 테스트 코드를 실행하기 전에 항상 먼저 실행되는 코드
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
//        System.out.println(todoDAO.getTime());
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO vo = TodoVO.builder()
                .title("Sample Title todo...")
                .dueDate(LocalDate.now())
                .build();
        todoDAO.insert(vo);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO vo = todoDAO.selectOne(4L);
        System.out.println(vo);
    }

    @Test
    public void testDeleteOne() throws Exception {
        todoDAO.deleteOne(1L);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(1L)
                .title("Update Title todo...")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoDAO.updateOne(vo);
    }
}
