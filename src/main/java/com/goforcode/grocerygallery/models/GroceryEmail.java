package com.goforcode.grocerygallery.models;

public class GroceryEmail {

	private String email;
	private String groceryUsername;
	private String emailSubject;
	private String emailText;
	private String emailHtml;

	public String getEmail() {
		return email;
	}

	public void setEmail(String address) {
		this.email = address;
	}

	public String getGroceryUsername() {
		return groceryUsername;
	}

	public void setGroceryUsername(String groceryUsername) {
		this.groceryUsername = groceryUsername;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getEmailHtml() {
		return emailHtml;
	}

	public void setEmailHtml(String emailHtml) {
		this.emailHtml = emailHtml;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

}
