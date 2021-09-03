package hepsiburada.homework.eventsimulator.generator;

import hepsiburada.homework.eventsimulator.model.Event;
import hepsiburada.homework.eventsimulator.producer.KafkaProducer;
import hepsiburada.homework.eventsimulator.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Random;

public class EventGenerator {

    private final long rowCount;
    private final long userCount;

    private final Random random;

    private final ProductService productService;

    public EventGenerator(ProductService productService) {

        this.productService = productService;

        rowCount = productService.getRowCount();
        userCount = 255;

        random = new Random();

    }

    private Long getTimestamp() {
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    private String getProductId() {
        int rowNumber = random.nextInt((int) rowCount) + 1; // [1, rowCount]

        return productService.getProductId(rowNumber).get(0).getProductId();
    }

    private String getUserId() {
        int userId = random.nextInt((int) userCount) + 1; // [1, userCount]
        return "user-" + userId;
    }

    public Event generate() {
        Event event = new Event();

        event.setProductId(getProductId());
        event.setUserId(getUserId());
        event.setTimestamp(getTimestamp());

        return event;
    }
}
