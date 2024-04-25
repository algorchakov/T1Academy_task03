package t1.openschool.task03.metricsconsumer.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class MetricsMapper {
    List<Metrics> metricsList = new ArrayList<>();

    public List<Metrics> mapper(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            Metrics metric = new Metrics();
            metric.setData(value);
            metric.setTime(key);
            metricsList.add(metric);
        }
        return metricsList;
    }
}
