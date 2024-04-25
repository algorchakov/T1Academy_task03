package t1.openschool.task03.metricsproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import t1.openschool.task03.metricsproducer.model.Metrics;

@SpringBootApplication
@Slf4j
public class MetricsProducerApplication {

    private final Metrics metrics;

    public MetricsProducerApplication(Metrics metrics) {
        this.metrics = metrics;
    }

    public static void main(String[] args) {
        SpringApplication.run(MetricsProducerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(fixedRate = 30000)
    public void test() {
        metrics.getMetric();
        log.info("Free memory: {}", metrics.getMetric());
    }
}
