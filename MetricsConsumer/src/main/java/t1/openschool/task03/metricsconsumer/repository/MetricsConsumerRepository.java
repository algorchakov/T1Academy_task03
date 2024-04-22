package t1.openschool.task03.metricsconsumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import t1.openschool.task03.metricsconsumer.model.Metrics;

import java.util.List;

@Repository
public interface MetricsConsumerRepository extends CrudRepository<Metrics, Long> {
    List<Metrics> findAll();
}
