package t1.openschool.task03.metricsconsumer.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Component
@Entity
@Table(name = "metrics")
@AllArgsConstructor
public class Metrics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String data;
}
