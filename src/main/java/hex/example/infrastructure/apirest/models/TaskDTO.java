package hex.example.infrastructure.apirest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Integer taskId;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
