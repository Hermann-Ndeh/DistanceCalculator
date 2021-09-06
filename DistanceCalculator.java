import java.util.Scanner;

public class DistanceCalculator {

        public static final int RADIUS_OF_EARTH = 6371000;

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        
        // prompt the user to input the Latitude
        System.out.print("Enter the Latitude: ");
        Double latitude = input.nextDouble();

        // prompt the user to input the Longitude
        System.out.print("Enter the Longitude: ");
        Double longitude = input.nextDouble();

        if ((latitude < -90 || latitude > 90) || (longitude <-180 || longitude > 180)){
            System.out.println("Error: Your latitude can only be between -90 and 90");
            System.out.println("Error: Your longitude can only be between -180 and 180");

        }
      
        // This is the formula to calculate the planar distance between 2 given points (x,y)
        double planarDistance = Math.sqrt((Math.pow(longitude, 2)) + (Math.pow(latitude, 2)));

        // This displays the output from the cumputation of the planar distance formula
        System.out.println("The planar distance is " + planarDistance);
        



        


    }
}