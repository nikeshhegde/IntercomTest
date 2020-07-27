package com.nikesh.intercomhometest.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.nikesh.intercomhometest.model.Customer;
/**
 * 
 * @author nhegd
 *
 */
public class JsonFileReader {
	
	/**
	 * 
	 * @param inputStream the stream of data extracted from the input file
	 * @return List of Customer object from the JSON data
	 * @throws IOException
	 */
	public static List<Customer> getCustomers(InputStream inputStream) throws IOException {
        List<JSONObject> customers = new ArrayList<>();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Constants.JSON_TXT_FILE_ENCODING))) {
            String line;
            while ((line = rd.readLine()) != null) {
                customers.add(new JSONObject(line));
            }
        }
        return getCustomersListFromJsonList(customers);
    }
	
	/**
	 * 
	 * @param customerJsonObjects each JSON line object from the input file
	 * @return Customer Object for each line read from the input file
	 */
    public static List<Customer> getCustomersListFromJsonList(List<JSONObject> customerJsonObjects){
        List<Customer> customers = new ArrayList<Customer>();
        for(JSONObject jsonObject: customerJsonObjects){
            Customer customer = new Customer(
                    Integer.parseInt(jsonObject.get(Constants.JSON_CUSTOMER_USER_ID_STRING).toString()),
                    jsonObject.get(Constants.JSON_CUSTOMER_NAME_STRING).toString(),
                    Double.parseDouble(jsonObject.get(Constants.JSON_CUSTOMER_LATITUDE_STRING).toString()),
                    Double.parseDouble(jsonObject.get(Constants.JSON_CUSTOMER_LONGITUDE_STRING).toString())
                    );
            customers.add(customer);
        }

        return customers;
    }
}
