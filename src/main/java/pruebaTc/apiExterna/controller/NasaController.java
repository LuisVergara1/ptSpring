package pruebaTc.apiExterna.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pruebaTc.apiExterna.dto.NasaResponse;
import pruebaTc.apiExterna.services.NasaService;

@RestController
public class NasaController {
    
    private final NasaService nasaService;
    
    public NasaController(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    @GetMapping("/api/nasa/apod")
    public NasaResponse getPictureTheDay(@RequestParam(required = false) String date) {
        return nasaService.getPictureTheDay(date);
    }
}
