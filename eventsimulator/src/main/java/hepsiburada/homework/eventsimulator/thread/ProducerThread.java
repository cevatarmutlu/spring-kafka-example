package hepsiburada.homework.eventsimulator.thread;

import hepsiburada.homework.eventsimulator.generator.EventGenerator;
import hepsiburada.homework.eventsimulator.producer.KafkaProducer;
import hepsiburada.homework.eventsimulator.service.ProductService;
import lombok.*;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProducerThread extends Thread{

    private final KafkaProducer kafkaProducer;
    private final ProductService productService;

    private static ProducerThread instance;
    
    public static ProducerThread getInstance(KafkaProducer kafkaProducer, ProductService productService) {
        if (instance == null) {
            instance = new ProducerThread(kafkaProducer, productService);
        }

        return instance;
    }

    @SneakyThrows
    @Override
    public void run() {

        EventGenerator eventGenerator = new EventGenerator(productService);

        while (true) {
            kafkaProducer.send(eventGenerator.generate());

            TimeUnit.SECONDS.sleep(1);
        }
    }
}
