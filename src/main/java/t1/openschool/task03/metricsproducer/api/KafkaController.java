package t1.openschool.task03.metricsproducer.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.openschool.task03.metricsproducer.model.Metrics;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@Slf4j
public class KafkaController {
    private final Metrics metrics;
    private final KafkaTemplate<Long, Map<LocalDateTime, Long>> template;

    public KafkaController(Metrics metrics, KafkaTemplate<Long, Map<LocalDateTime, Long>> template) {
        this.metrics = metrics;
        this.template = template;
    }

    @PostMapping(path = "/metrics/")
    public void sendTransactionMetrics() {
        template.executeInTransaction(kafkaTemplates -> {
            kafkaTemplates.send("metrics-topic", metrics.getMetric());
            log.info("sendTransactionMetrics: {}", metrics.getMetric());
            return 1;
        });
    }
}
