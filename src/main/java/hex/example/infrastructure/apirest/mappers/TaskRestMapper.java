package hex.example.infrastructure.apirest.mappers;

import hex.example.application.domain.Task;
import hex.example.infrastructure.apirest.models.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskRestMapper {

    TaskDTO toTaskDTORest(Task task);

    Task toTaskRest(TaskDTO taskDTO);

    default List<TaskDTO> toTaskDTOList(List<Task> tasks) {
        return tasks.stream().map(this::toTaskDTORest).collect(Collectors.toList());
    }

}
