package t1.openschool.task03.metricsproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Slf4j
public class Metrics {
    private long data;
    private LocalDateTime time;
    Map<LocalDateTime, Long> metricMap = new HashMap<>();

    public Map<LocalDateTime, Long> getMetric() {
        time = LocalDateTime.now();
        data = Runtime.getRuntime().freeMemory();
        metricMap.put(time, data);
        return metricMap;
    }
}
