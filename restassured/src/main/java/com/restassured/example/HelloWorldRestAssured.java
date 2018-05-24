package com.restassured.example;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class HelloWorldRestAssured {

	@org.junit.Test
	public void makeSureThatGoogleIsUp() {

		System.out.println(System.getProperties());
		Response response = given().when().get("http://localhost:8086/getEmployee");
		System.out.println(response.toString());

		response.print();

		// given().contentType("application/json").when().get("http://localhost:8086/getEmployee");

		// given().when().get("http://localhost:8086/getEmployee").then().body("name",equalTo("Acme
		// garage"));
		Map<String, Object> car = new HashMap<String, Object>();
		car.put("empID", "5476");
		car.put("empName", "Amaresh");
		car.put("empSalary", "100");
		car.put("empDesignation", "QA");

		response = given().contentType("application/json; charset=utf-8").body(car).when()
				.post("http://localhost:8086/createEmployee");
		response.print();

	}

}