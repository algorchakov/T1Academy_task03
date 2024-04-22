package t1.openschool.task03.metricsconsumer.service;

import t1.openschool.task03.metricsconsumer.model.Metrics;

import java.util.List;

public interface MetricsConsumerService {
    List<Metrics> findAll();

    Metrics findById(Long id);

    void saveMessage(List<Metrics> metrics);
}
