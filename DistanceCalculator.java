

import java.util.Scanner;

public class DistanceCalculator {

        public static final double EARTH_RADIUS = 3959; //miles
        public static final double MIN_LATITUDE = -90; //degrees
        public static final double MAX_LATITUDE = 90; //degrees
        public static final double MIN_LONGITUDE = -180; //degrees
        public static final double MAX_LONGITUDE = 180; //degrees
 
/** 
 * Calculates the distance between two points on the earth's surface assuming
 * the spherical earth has been projected to a plane.
 * This method assumes the input values are valid.
 * 
 * @param latitude1 latitude of first point in degrees
 * @param longitude1 longitude of first point in degrees
 * @param latitude2 latitude of second point in degrees
 * @param longitude2 longitude of second point in degrees
 * @return planar distance in miles between the two points
*/
    public static double calculatesPlanarDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
         // converting each entered latitude and longitude from degrees to radians
         double lat1 = Math.toRadians(latitude1);
         double lon1 = Math.toRadians(longitude1);
         double lat2 = Math.toRadians(latitude2);
         double lon2 = Math.toRadians(longitude2);
 
         double difflat = lat2 - lat1; //calculates the difference between both latitudes in radians
         double difflon = lon2 - lon1; // calculates the difference between both longitudes in radians
         double avlat = (lat1 + lat2) / 2; //calculates the average between both latitudes
        
        // This is the formula to calculate the planar distance between 2 given points (x,y)
        double D = EARTH_RADIUS * Math.sqrt(Math.pow(difflat,2) + Math.pow(Math.cos(avlat) * difflon, 2));
         // This displays the output from the cumputation of the planar distance formula
         System.out.println("Planar Distance: " + String.format("%.2f",D) + " mi");
        return D;
    }

/** 
 * Calculates the distance between two points on the earth's surface assuming
 * This method assumes the input values are valid.
 * 
 * @param latitude1 latitude of first point in degrees
 * @param longitude1 longitude of first point in degrees
 * @param latitude2 latitude of second point in degrees
 * @param longitude2 longitude of second point in degrees
 * @return spherical distance in miles between the two points
*/
    public static double calculateSphericalDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        // converting each entered latitude and longitude from degrees to radians
        double lat1 = Math.toRadians(latitude1);
        double lon1 = Math.toRadians(longitude1);
        double lat2 = Math.toRadians(latitude2);
        double lon2 = Math.toRadians(longitude2);

        double difflon = lon2 - lon1; // calculates the difference between both longitudes in radians

        //formula to calculate the Spherical distance
        double D = EARTH_RADIUS * Math.acos((Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(difflon)));
        // will display the calculated spherical distance above if all user inputs are within correct ranges
        System.out.println("Spherical Distance: " + String.format("%.2f",D) + " mi");
        return D;
    }
    public static void main(String[]args) {
        Scanner src = new Scanner(System.in); // initialize scanner to be called later on for input
        
        // prompt the user to input the first Latitude and calls scanner to get an input as a double
        System.out.print("Location 1 Latitude: ");
        Double latitude1 = src.nextDouble();
        
        //will check if the user input for the latitude is within the required range
        if (latitude1 < MIN_LATITUDE || latitude1 > MAX_LATITUDE){
            System.out.println("Invalid latitude");
            System.exit(1); //exits the program
        }
        // prompt the user to input the first longitude and calls scanner to get an input as a double
        System.out.print("Location 1 Longitude: ");
        Double longitude1 = src.nextDouble();

        //will check if the user input for the longitude is within the required range
        if (longitude1 < MIN_LONGITUDE || longitude1 > MAX_LONGITUDE){
            System.out.println("Invalid longitude");
            System.exit(1); //exits the program
        }

        // prompt the user to input the second Latitude and calls scanner to get an input as a double
        System.out.print("Location 2 Latitude: ");
        Double latitude2 = src.nextDouble();

        //will check to see if the user input for the latitude is within the expected range else the program will quit after error message
        if (latitude2 < MIN_LATITUDE || latitude2 > MAX_LATITUDE){
            System.out.println("Invalid latitude");
            System.exit(1);
        }
        // prompt the user to input the second Longitude and calls scanner to get an input as a double
        System.out.print("Location 2 Longitude: ");
        Double longitude2 = src.nextDouble();

        //will check to see if the user input for the longitude is within the expected range else the program will quit after error message
        if (longitude2 < MIN_LONGITUDE || longitude2 > MAX_LONGITUDE){
            System.out.println("Invalid longitude");
            System.exit(1);
        }

          // prompt the user to input the Distrance calculation type and calls scanner to get an input as a String
          System.out.print("Distance Calculation Type (P-laner, S-pherical): ");
          String dctype = src.next();

        if ((dctype.equals("P")) || (dctype.equals("p"))){
            calculatesPlanarDistance(latitude1, longitude1, latitude2, longitude2); //check to see if user input for string is P or p and calls the method to calculate the planar distance
        }
        else if ((dctype.equals("S")) || (dctype.equals("s")) ){
            calculateSphericalDistance(latitude1, longitude1, latitude2, longitude2); // check to see if use input for string is S or s and calls the method to calculate the spherical distance
        } 
        else {
            System.out.println("Invalid Type");
            System.exit(1); // if user input for string is neither P,p,S, or s, then the program displays and error message and exits
        }

       

    }
}