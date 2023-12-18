package org.testtask.routing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testtask.routing.model.CountryModel;
import org.testtask.routing.service.RouteService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/routing")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/")
    public List<CountryModel> getListOfCountry() {
        return routeService.getListOfCountries();
    }

    @GetMapping("/{cca}")
    public CountryModel getCountryByCca(@PathVariable String cca) {
        return routeService.getCountry(cca);
    }

    @GetMapping("/{root}/{goal}")
    public List<String> search(@PathVariable String root, @PathVariable String goal) {
        List<String> route = routeService.search(root, goal);
        if (route.isEmpty()) {
            throw new RuntimeException(String.valueOf(HttpStatus.BAD_REQUEST));
        }
        return route;

    }
}
