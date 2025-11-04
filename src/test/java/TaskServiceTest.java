import com.example.TaskList.modal.Task;
import com.example.TaskList.repository.TaskRepo;
import com.example.TaskList.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Date;

public class TaskServiceTest {
    private TaskRepo taskRepo;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepo = mock(TaskRepo.class);
        taskService = new TaskService(taskRepo);
    }

    @Test
    void testCreateTaskService_ShouldReturnSuccessMessage() {
        // given
        Task task = new Task();
        task.setTitle("Testing Feature");
        task.setDescription("This is a valid description");
        task.setDueDate(new Date());

        // when
        when(taskRepo.save(task)).thenReturn(task);
        String message = taskService.createTaskService(task);

        // then
        verify(taskRepo, times(1)).save(task);
        assertEquals("Task created for: Testing Feature", message);
    }
}
