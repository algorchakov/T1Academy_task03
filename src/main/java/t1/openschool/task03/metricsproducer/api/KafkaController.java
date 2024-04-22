package t1.openschool.task03.metricsproducer.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.openschool.task03.metricsproducer.model.Metrics;

@RestController
@Slf4j
public class KafkaController {
    private final Metrics metrics;
    private final KafkaTemplate<Object, Object> template;

    public KafkaController(Metrics metrics, KafkaTemplate<Object, Object> template) {
        this.metrics = metrics;
        this.template = template;
    }

    @PostMapping(path = "/metrics/")
    public void sendTransactionMetrics() {
        template.executeInTransaction(kafkaTemplates -> {
            metrics.getMetricList()
                    .forEach(metrics -> kafkaTemplates.send("metrics-topic", metrics));
            log.info("sendTransactionMetrics: {}", metrics.getMetricList());
            return 1;
        });
    }
}
