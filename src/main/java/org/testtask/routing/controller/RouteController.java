package org.testtask.routing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testtask.routing.model.CountryModel;
import org.testtask.routing.service.RouteService;
import java.util.List;

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
        return routeService.getCountryByCca3(cca);
    }
}
