package com.csc340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(){
		return "Hello, World!";
	}

	@GetMapping("/bike")
	public Object getBike() {
		try {
			String url = "http://api.citybik.es/v2/networks/";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			String jsonListResponse = restTemplate.getForObject(url, String.class);
			JsonNode root = mapper.readTree(jsonListResponse);

			List<BikeNetwork> bikeList = new ArrayList<>();

			JsonNode networks = root.get("networks");

			for (JsonNode network : networks) {
				String company = network.get("company") != null ? network.get("company").toString() : "N/A";
				String name = network.get("name").asText();
				String id = network.get("id").asText();

				BikeNetwork bikeNetwork = new BikeNetwork(company, name, id);
				bikeList.add(bikeNetwork);
			}
			return bikeList;
		} catch (JsonProcessingException ex) {
			Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE,
					null, ex);
			return "error in /bike";
		}
	}
}

