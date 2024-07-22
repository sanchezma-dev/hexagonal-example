package hex.example.infrastructure.sql.repository;

import hex.example.infrastructure.sql.models.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJPARepository extends JpaRepository<TaskEntity, Integer> {

}
