package org.testtask.routing.model;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryModel {

    private String cca3;
    private List<String> borders;

}
