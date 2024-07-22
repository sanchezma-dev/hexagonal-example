package hex.example.infrastructure.sql.adapters;

import hex.example.application.domain.User;
import hex.example.application.ports.out.UserRepositoryPort;
import hex.example.infrastructure.sql.mappers.UserDomainMapper;
import hex.example.infrastructure.sql.repository.UserJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJPARepository repository;
    private final UserDomainMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.toUserDomainList(repository.findAll());
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return repository.findById(userId)
                .map(mapper::toUserDomain);
    }

    @Override
    public User saveUser(User userNew) {
        var userEntityNew = mapper.toUserEntity(userNew);
        return mapper.toUserDomain(repository.save(userEntityNew));
    }

    @Override
    public boolean existsUser(Integer userId) {
        return repository.existsById(userId);
    }
}
