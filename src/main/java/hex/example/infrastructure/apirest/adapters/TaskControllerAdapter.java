package hex.example.infrastructure.apirest.adapters;

import hex.example.application.ports.in.TaskServicePort;
import hex.example.infrastructure.apirest.mappers.TaskRestMapper;
import hex.example.infrastructure.apirest.models.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/app/task/v1/")
public class TaskControllerAdapter {

    private final TaskServicePort taskServicePort;
    private final TaskRestMapper taskRestMapper;

    @PostMapping("/createTask/{userId}")
    public ResponseEntity<TaskDTO> createTask(@PathVariable Integer userId, @RequestBody final TaskDTO newTaskDTO) {
        var response = taskServicePort.saveTask(userId, taskRestMapper.toTaskRest(newTaskDTO));
        return ResponseEntity.ok(taskRestMapper.toTaskDTORest(response));

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> tasks() {
        var response = taskServicePort.findAllTasks();
        return ResponseEntity.ok(taskRestMapper.toTaskDTOList(response));

    }
}
