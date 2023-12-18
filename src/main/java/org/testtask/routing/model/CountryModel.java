package org.testtask.routing.model;

import lombok.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryModel {

    private String cca3;
    private List<String> borders;

    public void connect(CountryModel country) {
        if (this == country) throw new IllegalArgumentException("Can't connect country to itself");
        this.borders.add(country.cca3);
        country.borders.add(this.cca3);
    }

}
