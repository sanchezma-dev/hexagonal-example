package hex.example.application.ports.in;

import hex.example.application.domain.User;

import java.util.List;

public interface UserServicePort {

    List<User> findAllUsers();

    User saveUser(final User userNew);

}
