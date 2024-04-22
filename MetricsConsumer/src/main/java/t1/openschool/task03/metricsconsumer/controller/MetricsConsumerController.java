package t1.openschool.task03.metricsconsumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import t1.openschool.task03.metricsconsumer.model.Metrics;
import t1.openschool.task03.metricsconsumer.service.MetricsConsumerServiceImpl;

import java.util.List;

@RestController
public class MetricsConsumerController {

    private final MetricsConsumerServiceImpl metricsConsumerService;

    public MetricsConsumerController(MetricsConsumerServiceImpl metricsConsumerService) {
        this.metricsConsumerService = metricsConsumerService;
    }

    @GetMapping(path = "/metrics")
    public ResponseEntity<List<Metrics>> getAll() {
        List<Metrics> allMetrics = metricsConsumerService.findAll();
        return new ResponseEntity<>(allMetrics, HttpStatus.OK);
    }

    @GetMapping(path = "/metrics/{id}")
    public ResponseEntity<Metrics> getById(@PathVariable Long id) {
        Metrics metrics = metricsConsumerService.findById(id);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

}
