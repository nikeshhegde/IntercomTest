package com.nikesh.intercomhometest.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nikesh.intercomhometest.model.Customer;

public class CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	private CustomerService() {
	}

	/**
	 * 
	 * @param customersToFilter raw customers from JSON which will be compared with
	 *                          the range
	 * @param kilometerRange    range of distance
	 * @return List of Customers data within the valid range
	 */

	public static List<Customer> getCustomersWithinDistance(List<Customer> customersToFilter, Double kilometerRange, Double gpsLat, Double gpsLong) {
		List<Customer> customersInRange = new ArrayList<>();

		for (Customer customer : customersToFilter) {
			if (kilometerRange.compareTo(CalculateDistance.getDistanceInKm(customer.getLatitude(),
					customer.getLongitude(), gpsLat, gpsLong)) > 0) {
				customersInRange.add(customer);
			}
		}
		return customersInRange;
	}

	/**
	 * 
	 * @param fileUrl    this is the file path from which we will get JSON data
	 * @param validRange the range considered to compare
	 * @return List of Customers out of the original customer data
	 */

	public static List<Customer> processCustomerData(String fileUrl, double validRange) {
		LOGGER.log(Level.INFO, () -> "Getting List of customers within " + validRange + "km Range");
		try {

			LOGGER.log(Level.INFO, () -> "Reading Customer data from " + fileUrl);

			InputStream inputStream = new URL(fileUrl).openStream();

			// get all customers
			List<Customer> customers = JsonFileReader.getCustomers(inputStream);
			
			double officeLatitide = Constants.DUBLIN_OFFICE_LATITUDE;
			double officeLongitude = Constants.DUBLIN_OFFICE_LONGITUDE;
			
			// get the customers who are in range
			List<Customer> customersInRange = getCustomersWithinDistance(customers, validRange, officeLatitide, officeLongitude);

			LOGGER.log(Level.INFO, () -> "Total no of customers in file " + customers.size() + ", from which "
					+ customersInRange.size() + " are within a " + validRange + "km Range.");

			// sort the records according to the user id
			customersInRange.sort(Comparator.comparingInt(Customer::getUserId));

			// to store user id and name and print them
			StringBuilder sb = new StringBuilder();
			for (Customer cust : customersInRange) {
				sb.append(cust).append(System.lineSeparator());
			}

			LOGGER.log(Level.INFO, () -> "List of customers in range: " + System.lineSeparator()
					+ System.lineSeparator() + sb.toString());

			// pass the string builder containing the values to write in output.txt
			WriteToFile(sb);
			return customersInRange;

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "An Error has occurred, Exiting Application: " + e.toString());
			return new ArrayList<>();
		}

	}

	/**
	 * 
	 * @param This method writes the values to output.txt
	 */
	public static void WriteToFile(StringBuilder sb) {
		LOGGER.log(Level.INFO, () -> "Reading the values from StringBuilder ");
		BufferedWriter writer = null;
		Path path = Paths.get("output.txt");
		File f = new File(path.toString());
		try {
			if (f.delete()) {
				Files.createFile(path);
			}
			writer = new BufferedWriter(new FileWriter(path.toString()));
			writer.write(sb.toString());
			writer.close();
			LOGGER.log(Level.INFO, () -> "The values was succesfully written to a file " + path.toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
