package org.testtask.routing.client;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {

    public static final String BASE_URL = "https://raw.githubusercontent.com";

    public JsonNode getJsonAsString() {
        Unirest.config().defaultBaseUrl(BASE_URL);
        HttpResponse<kong.unirest.core.JsonNode> response = Unirest.get("/mledoze/countries/master/countries.json").asJson();

        return response.getBody();
    }


}
