package com.nikesh.intercomhometest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nikesh.intercomhometest.model.Customer;
import com.nikesh.intercomhometest.utils.Constants;
import com.nikesh.intercomhometest.utils.CustomerService;

public class CalculateDistanceTest {

	/**
	 * Test the program with custom data given in line
	 */
	@Test
	public void getCustomersWithinDistanceTest() {

		List<Customer> customersToFilter = new ArrayList<>();
		customersToFilter.add(new Customer(2, "Christina", 53.2451022d, -6.238335d));
		customersToFilter.add(new Customer(8, "Nora", 55.033d, -8.112d));
		customersToFilter.add(new Customer(4, "Olive", 53d, -7d));
		customersToFilter.add(new Customer(6, "Lisa", 51.92893d, -10.27699d));
		customersToFilter.add(new Customer(6, "Charlie", 51.92893d, -10.27699d));

		double officeLatitide = 53.339428;
		double officeLongitude = -6.257664;

		Double kilometerRange = 100d;

		List<Customer> customersInRange = CustomerService.getCustomersWithinDistance(customersToFilter, kilometerRange,officeLatitide ,officeLongitude);

		assertEquals(2, customersInRange.size());
		assertEquals(2, customersInRange.get(0).getUserId());
		assertEquals(4, customersInRange.get(1).getUserId());

	}

	/**
	 * To test the valid values from the output for the given URL which contains the
	 * JSON data
	 */
	@Test
	public void processCustomerDataTest() {

		List<Customer> customers = CustomerService.processCustomerData(Constants.DEFAULT_JSON_TXT_FILE_INPUT_URL,
				Constants.DEFAULT_VALID_RANGE_IN_KM);

		assertEquals("Lisa Ahearn", customers.get(15).getName());
		assertEquals(11, customers.get(4).getUserId());

	}

	/**
	 * Test the behavior of the program for any string of URL
	 */
	@Test
	public void processCustomerDataErrorTest() {

		List<Customer> customers = CustomerService.processCustomerData(
				"Junk url which has no data. Just a string value", Constants.DEFAULT_VALID_RANGE_IN_KM);

		assertTrue(customers.isEmpty());

	}

}
