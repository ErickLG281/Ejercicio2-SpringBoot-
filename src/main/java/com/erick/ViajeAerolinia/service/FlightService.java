package com.erick.ViajeAerolinia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FlightService {

    @Value("${aviation.api.key}")
    private String apiKey;

    private static final String API_URL = "https://aviationapi.com/v1/airlines";  // Cambia esta URL según la API que utilices

    public String getFlightSchedule(String airlineCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("api_key", apiKey)
                .queryParam("airline_code", airlineCode)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
