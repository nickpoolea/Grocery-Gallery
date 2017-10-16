package com.goforcode.grocerygallery.services;

import org.springframework.stereotype.Service;

import com.goforcode.grocerygallery.models.GroceryEmail;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class MailService {

	public String sendMail(GroceryEmail email) throws UnirestException {
		String api_key = "key-19cdea362d6c8eb33602a7ec083534b3";
		HttpResponse<String> request = Unirest
				.post("https://api.mailgun.net/v3/sandboxc4f0c1cfb73b4ff9935b561843555ba9.mailgun.org/messages")
				.basicAuth("api", api_key)
				.queryString("from", "Mailgun Sandbox <postmaster@sandboxc4f0c1cfb73b4ff9935b561843555ba9.mailgun.org>")
				.queryString("to", email.getEmail())
				.queryString("subject", email.getEmailSubject())
				.queryString("text", email.getEmailText())
				.queryString("html", email.getEmailHtml())
				.asString();
		return request.getBody();
	}
}