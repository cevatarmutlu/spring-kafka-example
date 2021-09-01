package hepsiburada.homework.api.controller;

import hepsiburada.homework.api.model.BestsellerQueryResponse;
import hepsiburada.homework.api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bestseller")
@RequiredArgsConstructor
public class APIController {

    @Autowired
    private EventService service;

    @GetMapping(value = "/tm/{maxProductCount}")
    public List<BestsellerQueryResponse> aa(@PathVariable("maxProductCount") int limit) {
        return service.getAll(limit);
    }
}
