package hex.example.application.services;

import hex.example.application.domain.Task;
import hex.example.application.domain.User;
import hex.example.application.exceptions.ApiResponseException;
import hex.example.application.ports.in.TaskServicePort;
import hex.example.application.ports.in.UserServicePort;
import hex.example.application.ports.out.TaskRepositoryPort;
import hex.example.application.ports.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServicesUseCase implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<User> findAllUsers() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User saveUser(User userNew) {
        if (userRepositoryPort.existsUser(userNew.getUserId())) {
            throw ApiResponseException.of("User to be saved already exists", HttpStatus.CONFLICT);
        }
        return userRepositoryPort.saveUser(userNew);
    }
}
