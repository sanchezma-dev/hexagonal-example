package hex.example.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer taskId;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;

    private User user;
}
