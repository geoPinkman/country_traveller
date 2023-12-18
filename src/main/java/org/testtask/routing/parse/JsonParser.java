package org.testtask.routing.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.testtask.routing.client.HttpClient;
import org.testtask.routing.model.CountryModel;
import java.util.List;

@Component
@AllArgsConstructor
public class JsonParser {

    private final HttpClient httpClient;

    public List<CountryModel> parseCountries() {
        String jsonNode = httpClient.getJsonAsString().toString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<CountryModel>> listType = new TypeReference<>() {};
        List<CountryModel> jacksonList = null;
        try {
            jacksonList = objectMapper.readValue(jsonNode, listType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jacksonList;
    }

}
