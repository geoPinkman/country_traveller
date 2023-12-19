package org.testtask.routing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.testtask.routing.model.CountryModel;
import org.testtask.routing.parse.JsonParser;
import java.util.*;

@Service
@AllArgsConstructor
public class RouteService {

    private final JsonParser jsonParser;

    public List<CountryModel> getListOfCountries() {
        return jsonParser.parseCountries();
    }

    public CountryModel getCountry(String cca) {
        return jsonParser.parseCountries().stream().filter(c -> c.getCca3().equalsIgnoreCase(cca))
                .findFirst()
                . get();

    }

    private CountryModel getCountryByCca3(String cca, List<CountryModel> countries) {
        return countries.stream().filter(c -> c.getCca3().equalsIgnoreCase(cca))
                .findFirst()
                .get();
    }

    public List<String> search(String root, String goal) {
        List<CountryModel> countries = getListOfCountries();
        Queue<String> queue = new ArrayDeque<>();
        List<String> alreadyVisited = new ArrayList<>();
        queue.add(root);

        String currentCountry;

        while (!queue.isEmpty()) {
            currentCountry = queue.remove();
            if (currentCountry.equalsIgnoreCase(goal)) {
                alreadyVisited.add(goal);
                return makeRoute(countries, alreadyVisited, goal, root);
        } else {
            alreadyVisited.add(currentCountry);
            queue.addAll(getCountryByCca3(currentCountry, countries).getBorders());
            queue.removeAll(alreadyVisited);
            }
        }
        return new ArrayList<>();
    }

    public List<String> makeRoute(List<CountryModel> countries, List<String> visitedCountries, String goal, String root) {
        List<String> pureRoute = new ArrayList<>();
        List<String> backRoute = new ArrayList<>();
        String previousCounty = "";
        backRoute.add(goal);
        while (!previousCounty.equals(root)) {
            List<String> borders = getCountryByCca3(goal, countries).getBorders();
            previousCounty = borders
                    .stream()
                    .filter(visitedCountries::contains)
                    .findFirst()
                    .get();
            if (!previousCounty.equals(root)) {
                backRoute.add(previousCounty);
                goal = previousCounty;
                visitedCountries = visitedCountries.subList(0, visitedCountries.indexOf(goal));
            } else {
                backRoute.add(previousCounty);
            }
        }
        for (int i = backRoute.size() - 1; i >= 0 ; i--) {
            pureRoute.add(backRoute.get(i));
        }
        return pureRoute;
    }

}
