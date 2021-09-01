package hepsiburada.homework.eventsimulator.producer;

import hepsiburada.homework.eventsimulator.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Value(value = "${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void send(Event event) {
        kafkaTemplate.send(topic, event);
        LOGGER.info("sending payload='{}' to topic='{}'", event, topic);
    }
}
