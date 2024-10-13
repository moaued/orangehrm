package utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Helper {
	  public static int generateRandomNumber(int min, int max) {
	        // Create an instance of the Random class
	        Random random = new Random();

	        // Generate a random number between min (inclusive) and max (inclusive)
	        return random.nextInt((max - min) + 1) + min;
	    }
	  
	  
	  
	  
	  
	  private static final String FILE_PATH = "src/test/resources/testdata/empData.json";

	    public static void main(String[] args) {
	        // Call the method to read empNumber
	        String employeeId = readEmpNumberFromJsonFile();
	        String randomStreet = generateRandomStreetName();
	        // Use empNumber if it's not null
	        if (employeeId != null) {
	            System.out.println("Employee Number: " + employeeId);
	        } else {
	            System.out.println("empNumber not found in JSON file.");
	        }
	    }

	    public static String readEmpNumberFromJsonFile() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        String empNumber = null;

	        try {
	            // Read the JSON file into a Map
	            Map<String, String> empData = objectMapper.readValue(
	                    new File(FILE_PATH), 
	                    new TypeReference<Map<String, String>>() {}
	            );

	            // Get the empNumber value from the Map
	            empNumber = empData.get("employeeId");
	            System.out.println("Read empNumber from JSON file: " + empNumber);
	        } catch (IOException e) {
	            System.err.println("Error reading the JSON file: " + e.getMessage());
	            e.printStackTrace();
	        }

	        return empNumber;
	    }
	  
	  
	    private static final String[] STREET_NAMES = {
	            "Oak", "Maple", "Pine", "Cedar", "Elm", "Birch", "Willow", "Aspen", "Ash", "Beech", "Cherry", "Fir"
	        };
	        
	        private static final String[] STREET_TYPES = {
	            "Street", "Avenue", "Boulevard", "Drive", "Lane", "Road", "Terrace", "Place", "Court"
	        };

	        // Function to generate a random street name
	        public static String generateRandomStreetName() {
	            Random random = new Random();
	            
	            // Select a random name and street type from the arrays
	            String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)];
	            String streetType = STREET_TYPES[random.nextInt(STREET_TYPES.length)];
	            
	            // Combine them to form a street name
	            return streetName + " " + streetType;
	        }

	        public static String getTodayDate() {
	            LocalDate today = LocalDate.now(); // Get today's date
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format the date
	            return today.format(formatter); // Return the formatted date as a string
	        }
	        public static void captureScreenshot(WebDriver driver , String screenshotname) 
	    	{
	    		Path dest = Paths.get("./Screenshots",screenshotname+".png"); 
	    		try {
	    			Files.createDirectories(dest.getParent());
	    			FileOutputStream out = new FileOutputStream(dest.toString());
	    			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	    			out.close();
	    		} catch (IOException e) {
	    			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
	    		}
	    	}
	  
}
