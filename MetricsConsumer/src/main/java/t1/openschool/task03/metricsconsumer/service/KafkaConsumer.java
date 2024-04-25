package t1.openschool.task03.metricsconsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import t1.openschool.task03.metricsconsumer.model.MetricsMapper;

import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {
    private final MetricsConsumerServiceImpl metricsConsumerService;
    private final MetricsMapper mapper;

    public KafkaConsumer(MetricsConsumerServiceImpl metricsConsumerService, MetricsMapper mapper) {
        this.metricsConsumerService = metricsConsumerService;
        this.mapper = mapper;
    }

    @KafkaListener(id = "metricsGroup", topics = "metrics-topic")
    public void listen(Map<String, Integer> in) {
        log.info("Message received: {}", in);
        metricsConsumerService.saveMessage(mapper.mapper(in));
    }
}
