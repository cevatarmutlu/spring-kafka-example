package hepsiburada.homework.eventconsumer.controller;

import hepsiburada.homework.eventconsumer.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventConsumerController {


    private final KafkaConsumer kafkaConsumer;

    @GetMapping(value = "/consume")
    public String consume() {
        return kafkaConsumer.getPayload();
    }
}
