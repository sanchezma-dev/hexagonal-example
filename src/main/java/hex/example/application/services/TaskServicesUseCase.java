package hex.example.application.services;

import hex.example.application.domain.Task;
import hex.example.application.exceptions.ApiResponseException;
import hex.example.application.ports.in.TaskServicePort;
import hex.example.application.ports.out.TaskRepositoryPort;
import hex.example.application.ports.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServicesUseCase implements TaskServicePort {

    private final TaskRepositoryPort taskRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<Task> findAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Override
    public Task saveTask(Integer userId, Task taskNew) {
        var user = userRepositoryPort.findById(userId)
                .orElseThrow(() -> ApiResponseException.of("User not found with id: " + userId, HttpStatus.NOT_FOUND));
        taskNew.setUser(user);

        return taskRepositoryPort.save(taskNew);
    }

}
