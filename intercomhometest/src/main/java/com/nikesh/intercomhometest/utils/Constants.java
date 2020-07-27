package com.nikesh.intercomhometest.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Constants {
	
	public static final String DEFAULT_JSON_TXT_FILE_INPUT_URL = "https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
	public static final Charset JSON_TXT_FILE_ENCODING = StandardCharsets.UTF_8;
	
    public static final String JSON_CUSTOMER_USER_ID_STRING = "user_id";
    public static final String JSON_CUSTOMER_NAME_STRING = "name";
    public static final String JSON_CUSTOMER_LATITUDE_STRING = "latitude";
    public static final String JSON_CUSTOMER_LONGITUDE_STRING = "longitude";
    
	public static final double DUBLIN_OFFICE_LATITUDE = 53.339428;
    public static final double DUBLIN_OFFICE_LONGITUDE = -6.257664;
    public static final double DEFAULT_VALID_RANGE_IN_KM = 100;
    public static final String DISTANCE_UNIT ="KM";
}
