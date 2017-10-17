package com.goforcode.grocerygallery.services;


import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiSearchService {
	
	private String searchUrl = "https://shelf-life-api.herokuapp.com/search?q=";
	private String detailUrl = "https://shelf-life-api.herokuapp.com/guides/";

	public JsonNode searchForItems(String queryString) throws JsonProcessingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(searchUrl + queryString, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		return root;
	}
	
	public JsonNode getDetailsOfItem(String itemId) throws JsonProcessingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(detailUrl + itemId, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		for (int i = 0; i < root.size(); i++) {
			System.out.println(root.path("methods").get(i));
		}
		System.out.println("Root Total" + root.path("methods"));
		return root;
	}
	

}
