package hepsiburada.homework.eventsimulator.controller;

import hepsiburada.homework.eventsimulator.producer.KafkaProducer;
import hepsiburada.homework.eventsimulator.service.ProductService;
import hepsiburada.homework.eventsimulator.thread.ProducerThread;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventSimulatorController {

    @Autowired
    private ProductService productService;

    private final KafkaProducer kafkaProducer;

    @GetMapping(value = "/produce")
    public String produce() {

        try {
            ProducerThread producerThread = ProducerThread.getInstance(kafkaProducer, productService);
            producerThread.start();
        }catch (Exception e) {
            return "Failed to write event to Kafka";
        }

        return "Successfully";
    }

}
