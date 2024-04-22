package t1.openschool.task03.metricsproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@Component
@Slf4j
public class Metrics {
    private List<Long> metricList;

    public Long getMetric() {
        metricList.add(Runtime.getRuntime().freeMemory());
        log.info("Metrics list: {}", metricList);
        return Runtime.getRuntime().freeMemory();
    }
}
