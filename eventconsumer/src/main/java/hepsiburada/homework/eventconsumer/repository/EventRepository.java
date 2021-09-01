package hepsiburada.homework.eventconsumer.repository;

import hepsiburada.homework.eventconsumer.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {
}
