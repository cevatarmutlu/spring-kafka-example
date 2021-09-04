package hepsiburada.homework.api.controller;

import hepsiburada.homework.api.model.BestsellerQueryResponse;
import hepsiburada.homework.api.model.Event;
import hepsiburada.homework.api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@Validated
public class APIController {

    @Autowired
    private EventService service;

    @GetMapping(value = "/bestseller")
    public List<BestsellerQueryResponse> bestseller(
            @RequestParam Integer maxProductCount
    ) {
        return service.getBestsellerProducts(maxProductCount);
    }

    @GetMapping("/all")
    public List<Event> all() {
        return service.getAll();
    }
}
