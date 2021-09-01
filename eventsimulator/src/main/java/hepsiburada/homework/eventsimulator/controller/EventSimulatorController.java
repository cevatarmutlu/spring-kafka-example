package hepsiburada.homework.eventsimulator.controller;

import hepsiburada.homework.eventsimulator.generator.EventGenerator;
import hepsiburada.homework.eventsimulator.producer.KafkaProducer;
import hepsiburada.homework.eventsimulator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventSimulatorController {

    @Autowired
    private ProductService productService;

    private final KafkaProducer kafkaProducer;

    @GetMapping(value = "/produce")
    public void produce() throws InterruptedException {

         // Global olarak çalıştıramadım. O yüzden burada

        EventGenerator eventGenerator = new EventGenerator(productService);

        while (true) {
            kafkaProducer.send(eventGenerator.generate());

            TimeUnit.SECONDS.sleep(1);
        }

    }

}
