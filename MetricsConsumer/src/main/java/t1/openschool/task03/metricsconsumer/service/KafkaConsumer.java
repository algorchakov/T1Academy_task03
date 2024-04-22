package t1.openschool.task03.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import t1.openschool.task03.metricsconsumer.model.Metrics;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    @Autowired
    MetricsConsumerServiceImpl metricsConsumerService;

    @KafkaListener(id = "metricsGroup", topics = "metrics-topic")
    public void listen(List<String> in) {
        log.info("Message received: {}", in);

        List<Metrics> receiveMetrics = in.stream()
                .map(mtr -> Metrics.builder().data(mtr).build()).toList();
        metricsConsumerService.saveMessage(receiveMetrics);
    }
}
