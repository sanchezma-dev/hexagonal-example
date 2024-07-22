package hex.example.application.ports.out;

import hex.example.application.domain.Task;

import java.util.List;

public interface TaskRepositoryPort {

    List<Task> findAll();

    Task save(final Task taskNew);
}
