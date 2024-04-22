package t1.openschool.task03.metricsconsumer.service;

import org.springframework.stereotype.Service;
import t1.openschool.task03.metricsconsumer.model.Metrics;
import t1.openschool.task03.metricsconsumer.repository.MetricsConsumerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsConsumerServiceImpl implements MetricsConsumerService {
    private final MetricsConsumerRepository metricsConsumerRepository;

    public MetricsConsumerServiceImpl(MetricsConsumerRepository metricsConsumerRepository) {
        this.metricsConsumerRepository = metricsConsumerRepository;
    }

    public List<Metrics> findAll() {
        return new ArrayList<>(metricsConsumerRepository.findAll());
    }

    public Metrics findById(Long id) {
        return metricsConsumerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No such metric was found\n"));
    }

    public void saveMessage(List<Metrics> metricsList) {
        metricsConsumerRepository.saveAll(metricsList);
    }
}
