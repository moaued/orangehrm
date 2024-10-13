package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath; 
import utilities.Helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class AddUsers {
	 private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/pim/employees"; 
	    int id = Helper.generateRandomNumber(1, 10000);  // Helper to generate random ID

	    @Test
	    public void testAddUserAndUserDetails() {
	        // Step 1: Add User
	        Response addUserResponse = addUser("Ayman", "Weal", "Ali", id);

	        // Step 2: Parse response to get employee ID and empNumber
	        String employeeId = parseEmployeeId(addUserResponse);
	        String empNumber = parseEmpNumber(addUserResponse);
	        saveEmpNumberToJsonFile(employeeId,empNumber);
            System.out.println("empNumber saved to JSON file: " + employeeId);
	        // Step 3: Assert that the user was added successfully
	        Assert.assertEquals(addUserResponse.getStatusCode(), 200, "User was not added successfully.");

	        // Step 4: Add details for the added user
	        if (employeeId != null && empNumber != null) {
	            Response detailResponse = addUserPersonalDetails(employeeId, empNumber);
	            System.out.println("Detail Response: " + detailResponse.asString());
	            Assert.assertEquals(detailResponse.getStatusCode(), 200, "User personal details not added successfully.");
	        } else {
	            Assert.fail("Failed to add user; cannot add personal details.");
	        }
	    }
	    private void saveEmpNumberToJsonFile(String employeeId,String empNumber) {
	        // Create a JSON object to save
	        Map<String, String> empData = new HashMap<>(); // Corrected this line
	        empData.put("employeeId", employeeId);
	        empData.put("empNumber", empNumber);

	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Make sure the directory exists before trying to write the file
	            File file = new File("src/test/resources/testdata/empData.json");
	            file.getParentFile().mkdirs(); // Create the directory if it doesn't exist
	            objectMapper.writeValue(file, empData); // Adjust path as needed
	            System.out.println("empNumber saved to JSON file: " + employeeId);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private Response addUser(String firstName, String middleName, String lastName, int employeeId) {
	        String jsonString = String.format(
	                "{\"firstName\":\"%s\",\"middleName\":\"%s\",\"lastName\":\"%s\",\"employeeId\":\"%s\"}",
	                firstName, middleName, lastName, employeeId);

	        // Create the request
	        RequestSpecification request = RestAssured.given()
	                .baseUri(BASE_URL)
	                .contentType(ContentType.JSON)
	                .header("cookie", "orangehrm=l1t266ll6ki38rp12634vpcs5f")  // Replace with actual token
	                .body(jsonString);

	        // Send POST request
	        Response response = request.post();

	        // Print response for debugging
	        System.out.println("Add User Response: " + response.asString());

	        // Return the complete Response object
	        return response;
	    }

	    private String parseEmployeeId(Response response) {
	        // Parse the response to extract the employeeId
	        if (response.getStatusCode() == 200) {
	            return response.jsonPath().getString("data.employeeId");
	        }
	        return null;
	    }

	    private String parseEmpNumber(Response response) {
	        // Parse the response to extract the empNumber
	        if (response.getStatusCode() == 200) {
	            return response.jsonPath().getString("data.empNumber");
	        }
	        return null;
	    }
	
	    private Response addUserPersonalDetails(String employeeId, String empNumber) {
	        // Construct the URL using the employee ID
	        String url = BASE_URL + "/" + empNumber + "/personal-details";  // Adjust as needed

	        // Construct JSON string for user personal details
	        String detailsJsonString = String.format(
	                "{\"lastName\":\"Doe\",\"firstName\":\"John\",\"middleName\":\"Weal\",\"employeeId\":\"%s\"," +
	                        "\"otherId\":\"5\",\"drivingLicenseNo\":\"5845\",\"drivingLicenseExpiredDate\":\"2025-08-31\"," +
	                        "\"gender\":\"1\",\"maritalStatus\":\"Single\",\"birthday\":\"1998-11-30\",\"nationalityId\":55}",
	                employeeId);

	        RequestSpecification request = RestAssured.given()
	                .baseUri(url)
	                .contentType(ContentType.JSON)
	                .header("cookie", "oorangehrm=l1t266ll6ki38rp12634vpcs5f")  // Replace with actual token
	                .body(detailsJsonString);

	        // Send POST request
	        Response response = request.put();

	        // Print response for debugging
	        System.out.println("Add User Personal Details Response: " + response.asString());

	        return response;
	    }}

