package hex.example.application.ports.out;

import hex.example.application.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    List<User> findAll();

    Optional<User> findById(final Integer userId);

    User saveUser(final User userNew);

    boolean existsUser(final Integer userId);

}
