package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactApi {
	private static final String FILE_PATH = "src/test/java/resources/example.csv";
    private static final String API_URL = "http://intrumhomework.mocklab.io/v1/contact";
    
    public void CsvReader() throws IOException {
    String line;
	try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
		reader.readLine();
		
		while ((line = reader.readLine()) != null) {
		    String[] fields = line.split("\\|");
		    int id = Integer.parseInt(fields[0]);           
		    String firstName = fields[1];        
		    String lastName = fields[2];           
		    String email = fields[3];          
		    int companyId = Integer.parseInt(fields[4]);          
		    JSONObject payload = new JSONObject();
		    payload.put("id", id);
		    payload.put("firstName", firstName);
		    payload.put("lastName", lastName);
		    payload.put("email", email);
		    payload.put("companyId", companyId);

		    URL url = new URL(API_URL);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type", "application/json");
		    conn.setDoOutput(true);

		    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    writer.write(payload.toString());
		    writer.flush();

		    int responseCode = conn.getResponseCode();
		   // Assert.assertEquals(201, conn.getResponseCode());
		    if (responseCode == 201) {
		        System.out.println("Success with Response Code:"+responseCode);
		    } else {
		        System.out.println("POST request failed for row: " + line + ", response code: " + responseCode);
		    }  
		  }
	} catch (NumberFormatException | JSONException e) {
		
		e.printStackTrace();
	}
    }
}