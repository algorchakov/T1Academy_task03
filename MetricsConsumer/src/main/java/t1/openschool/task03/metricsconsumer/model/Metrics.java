package t1.openschool.task03.metricsconsumer.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Builder
@Component
@Entity
@Table(name = "metrics")
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String time;
    private int data;
}
