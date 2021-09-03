package hepsiburada.homework.api.service;

import hepsiburada.homework.api.model.BestsellerQueryResponse;
import hepsiburada.homework.api.model.Event;
import hepsiburada.homework.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<BestsellerQueryResponse> getBestsellerProducts(int limit) {
        return eventRepository.findBestsellerProducts(limit);
    }

    public List<Event> getAll() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);

        return events;
    }

}
