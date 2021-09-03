package hepsiburada.homework.eventsimulator;

import hepsiburada.homework.eventsimulator.generator.EventGenerator;
import hepsiburada.homework.eventsimulator.model.Event;
import hepsiburada.homework.eventsimulator.producer.KafkaProducer;
import hepsiburada.homework.eventsimulator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class EventSimulatorApplication {



	public static void main(String[] args) {
		SpringApplication.run(EventSimulatorApplication.class, args);
	}

}
