package com.scheduler.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SendNotification {
	/*
	 * public static void main( String[] args ) { try { HttpRequest request =
	 * HttpRequest.newBuilder() .uri(new
	 * URI("https://graph.facebook.com/v13.0/319515291226618/messages"))
	 * .header("Authorization", "Bearer 289517877574784") .header("Content-Type",
	 * "application/json") .POST(HttpRequest.BodyPublishers.
	 * ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"8396811535\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"
	 * )) .build(); HttpClient http = HttpClient.newHttpClient();
	 * HttpResponse<String> response = http.send(request,BodyHandlers.ofString());
	 * System.out.println(response.body());
	 * 
	 * } catch (URISyntaxException | IOException | InterruptedException e) {
	 * e.printStackTrace(); } }
	 */
}
