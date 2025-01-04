package pruebaTc.apiExterna.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pruebaTc.apiExterna.dto.NasaResponse;


@Service
public class NasaService {
    
    //URL del API NASA
    @Value("${nasa.api.url}")
    private String apiUrl;
    //Clave del API NASA
    @Value("${nasa.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;    
    
    public NasaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NasaResponse getPictureTheDay(String date) {
        String url = apiUrl + "?api_key=" + apiKey;
        if (date != null && !date.isBlank()) {
            url += "&date=" + date;
        }
        return restTemplate.getForObject(url, NasaResponse.class);
    }
}
