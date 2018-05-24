package com.restassured.example;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StatesOfCountry {

	@org.junit.Test
	public void allStatesOfCountry() {

//		Response response = given().when().get("http://services.groupkt.com/state/get/IND/KA");
		Response response = given().when().get("http://services.groupkt.com/state/get/IND/all");

		response.prettyPrint();

		/* 1. verify status code */
		response.then().statusCode(200);

		/* 2. verify countryCode */
//		response.then().body("RestResponse.result.country", equalTo("IND")).body("RestResponse.result.name",
//				equalTo("Karnataka"));
//		
//		response.then().body("RestResponse.result.name", hasItems("Andhra Pradesh,Arunachal Pradesh"));
		
		
		response.then().assertThat().body("RestResponse.result.name", hasValue("Jammu and Kashmir"));
		
//		
//		JsonPath jsonPath = new JsonPath(response.toString()).setRoot("RestResponse");
//		JsonObject lottoId = jsonPath.getJsonObject("result");
//		List<Integer> winnerIds = jsonPath.get("result.id");

	}

}
