package hex.example.infrastructure.sql.mappers;

import hex.example.application.domain.Task;
import hex.example.infrastructure.sql.models.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskDomainMapper {

    @Mapping(source = "user", target = "userEntity")
    TaskEntity toTaskEntity(Task task);

    @Mapping(source = "userEntity", target = "user")
    Task toTaskDomain(TaskEntity taskEntity);

    default List<Task> fromTaskEntityList(List<TaskEntity> taskEntityList) {
        return taskEntityList.stream().map(this::toTaskDomain).collect(Collectors.toList());
    }
}
