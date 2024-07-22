package hex.example.infrastructure.sql.adapters;

import hex.example.application.domain.Task;
import hex.example.application.ports.out.TaskRepositoryPort;
import hex.example.infrastructure.sql.mappers.TaskDomainMapper;
import hex.example.infrastructure.sql.repository.TaskJPARepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskJPARepository repository;
    private final TaskDomainMapper taskDomainMapper;

    @Override
    public List<Task> findAll() {
        return taskDomainMapper.fromTaskEntityList(repository.findAll());
    }

    @Override
    public Task save(Task taskNew) {
        var taskNewEntity = taskDomainMapper.toTaskEntity(taskNew);
        return taskDomainMapper.toTaskDomain(repository.save(taskNewEntity));
    }
}
