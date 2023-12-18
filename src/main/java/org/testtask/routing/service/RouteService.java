package org.testtask.routing.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.testtask.routing.model.CountryModel;
import org.testtask.routing.parse.JsonParser;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteService {

    private final JsonParser jsonParser;

    public List<CountryModel> getListOfCountries() {
        return jsonParser.parseCountries();
    }

    public CountryModel getCountryByCca3(String cca) {
        List<CountryModel> countries;
        countries = getListOfCountries();
        return countries.stream().filter(c -> c.getCca3().equalsIgnoreCase(cca))
                .findFirst()
                .get();
    }

    public Optional<CountryModel> search(String root, String goal) {
//        Queue<CountryModel> queue = new ArrayDeque<>();
//        queue.add(getCountryByCca3(root));
//
//        CountryModel currentCountry;
//
//        while (!queue.isEmpty()) {
//            currentCountry = queue.remove();
//
//            if (currentCountry.getCca3().equalsIgnoreCase(root)) {
//                return Optional.of(currentCountry);
//            } else {
//                queue.addAll(currentCountry.getCca3());
//            }
//        }

        return null;
    }

}
