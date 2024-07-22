package hex.example.infrastructure.sql.repository;

import hex.example.infrastructure.sql.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {

}
