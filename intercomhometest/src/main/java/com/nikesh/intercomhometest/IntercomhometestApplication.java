package com.nikesh.intercomhometest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nikesh.intercomhometest.utils.Constants;
import com.nikesh.intercomhometest.utils.CustomerService;

@SpringBootApplication
public class IntercomhometestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntercomhometestApplication.class, args);
        final double validRange = Constants.DEFAULT_VALID_RANGE_IN_KM;
        final String fileUrl = Constants.DEFAULT_JSON_TXT_FILE_INPUT_URL;
        // calls the customer service to process the data
        CustomerService.processCustomerData(fileUrl, validRange);
	}

}
