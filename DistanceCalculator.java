import java.util.*;

public class DistanceCalculator {

        // Radius of earth in miles
        public static final double RADIUS_OF_EARTH = 3959; 
    public static void main(String[]args) {
        Scanner src = new Scanner(System.in);
        
        // prompt the user to input the Latitude
        System.out.print("Location 1 Latitude: ");
        Double latitude1 = src.nextDouble();
        // prompt the user to input the Longitude
        System.out.print("Location 1 Longitude: ");
        Double longitude1 = src.nextDouble();

        // prompt the user to input the Latitude
        System.out.print("Location 2 Latitude: ");
        Double latitude2 = src.nextDouble();
        // prompt the user to input the Longitude
        System.out.print("Location 2 Longitude: ");
        Double longitude2 = src.nextDouble();

        System.out.print("Distance Calculation Type (P-laner, S-pherical): ");
        String lastName2 = src.nextLine();

        src.close();


        double lat1 = Math.toRadians(latitude1);
        double lon1 = Math.toRadians(longitude1);
        double lat2 = Math.toRadians(latitude2);
        double lon2 = Math.toRadians(longitude2);

        double difflat = lat2 - lat1;
        double difflon = lon2 - lon1;
        double avlat = (lat1 + lat2) / 2;


        if ((latitude1 < -90 || latitude1 > 90) || (latitude2 < -90 || latitude2 > 90)){
            System.out.println("Error: Your latitude can only be between -90 and 90");
        }
        else if  ((longitude1 <-180 || longitude1 > 180) || (longitude2 <-180 || longitude2 > 180)) {
            System.out.println("Error: Your longitude can only be between -180 and 180");
        } 
          
        if (lastName2 == "P") {
         // This is the formula to calculate the planar distance between 2 given points (x,y)
        double D = RADIUS_OF_EARTH * Math.sqrt(Math.pow(difflat,2) + Math.pow(Math.cos(avlat) * difflon, 2));
         // This displays the output from the cumputation of the planar distance formula
         System.out.println("The planar distance is " + D);
        }
      
       

    }
}