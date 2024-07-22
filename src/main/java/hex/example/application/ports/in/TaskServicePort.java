package hex.example.application.ports.in;

import hex.example.application.domain.Task;

import java.util.List;

public interface TaskServicePort {

    List<Task> findAllTasks();

    Task saveTask(final Integer userId, final Task taskNew);
}
