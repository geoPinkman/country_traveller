package org.testtask.routing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testtask.routing.parse.JsonParser;
import org.testtask.routing.service.RouteService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RouteService routeService(JsonParser jsonParser) {
        return new RouteService(jsonParser);
    }

}
