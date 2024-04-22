package t1.openschool.task03.metricsproducer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("metrics-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }
}
