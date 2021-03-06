//package com.goforcode.grocerygallery.services;
//
//
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.goforcode.grocerygallery.models.Item;
//
//@Service
//public class ApiSearchService {
//	
//	private String searchUrl = "https://shelf-life-api.herokuapp.com/search?q=";
//	private String detailUrl = "https://shelf-life-api.herokuapp.com/guides/";
//
//	public JsonNode searchForItems(String queryString) throws JsonProcessingException, IOException {
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity(searchUrl + queryString, String.class);
//		ObjectMapper mapper = new ObjectMapper();
//		
//		JsonNode root = mapper.readTree(response.getBody());
//	
//		return root;
//	}
//	
//	public Item jsonDetailsToObect(String itemId) throws JsonProcessingException, IOException {
//		int seconds_in_a_day = 86400;
//		int expirationDays = 0;
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity(detailUrl + itemId, String.class);
//		boolean isFinished = false;
//		
//		Date today = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(today);
//
//		Item item = new Item();		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = mapper.readTree(response.getBody());
//		JsonNode methods = root.path("methods");
//		JsonNode selectedMethod = null;
//		
//		System.out.println("Root: " + root);
//		
//		for (JsonNode method: methods) {
//			if (method.path("location").toString().contains("Refrigerator")) {
//				selectedMethod = method;
//				isFinished = true;
//			}
//		}
//		for (JsonNode method: methods) {
//			if (method.path("location").toString().contains("Pantry") && !isFinished) {
//				selectedMethod = method;
//				isFinished = true;
//			}
//		}
//		if (!isFinished) {
//			selectedMethod = methods.get(0);
//			isFinished = true;
//		}
//				
//		item.setName(root.path("name").toString().replaceAll("\"", ""));
//		item.setpurchasedDate(today);
//				
//		expirationDays = selectedMethod.path("expirationTime").asInt() / seconds_in_a_day;
//		cal.add(Calendar.DAY_OF_YEAR, expirationDays);
//		item.setExpirationDate(cal.getTime());
//			
//		return item;
//	}
//	
//
//}
