package com.nikesh.intercomhometest.utils;

/**
 * This class calculates the spherical distance of the two point of GPS
 * Follows the formula obtained from https://en.wikipedia.org/wiki/Great-circle_distance
 * @author nhegde
 *
 */
public class CalculateDistance {

	CalculateDistance() {
    }
	// method to return the distance in km
	public static double getDistanceInKm(double lat1, double lon1, double lat2, double lon2) {
		// Radius of the earth
		final int R = 6371;
		// if both are in same location
		if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist) * R;
            return (dist);
        }
	}
	
	
	
}
