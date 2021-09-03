package hepsiburada.homework.eventconsumer.consumer;

import hepsiburada.homework.eventconsumer.model.Event;
import hepsiburada.homework.eventconsumer.service.EventService;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Getter
@Setter
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private EventService service;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${kafka.topic}", id = "${kafka.group-id}")
    public void receive(@Payload Event event) {
        LOGGER.info("received data: {} ", event.toString());
        latch.countDown();

        service.save(event);
    }

}
