import com.ssg.webmvc.todo.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    // 각각의 테스트 코드를 실행하기 전에 항상 먼저 실행되는 코드
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
//        System.out.println(todoDAO.getTime2());
    }
}
