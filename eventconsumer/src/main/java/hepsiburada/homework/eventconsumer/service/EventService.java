package hepsiburada.homework.eventconsumer.service;

import hepsiburada.homework.eventconsumer.model.Event;
import hepsiburada.homework.eventconsumer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void save(Event event) {
        eventRepository.save(event);
    }
}
