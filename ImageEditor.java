/**
 *      Copy a source image and make edited copy
 *
 *      $ java -cp ImageEditor -choice source target
 *
 */
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class ImageEditor {

    private static Scanner in = new Scanner(System.in);

    public static int red = 0;
    public static int blue = 0;
    public static int green = 0;
    public static int x = 0;
    public static int y = 0;
    public static int pixels = 0;
    

    
    /**
     * Reads and validates the ppm file and returns
     * a 2D arraycontaining the pixel RGB values
     * 
     * The number of elements in each row of the array
     * will be 3 * the number of columns of pixels, since
     * 3 integers are used to represent each pixel.
     * 
     * 
     * @param in in is the scanner that is called
     * @return
     */
    public static int[][] getPixelValues(Scanner in) {
        //Retrieving contents of a pixel
        int pixel = img.getRGB(x,y);
        //Creating a Color object from pixel value
        Color color = new Color(pixel, true);
        //Retrieving the R G B values
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        //Modifying the RGB values
        return null;
                                
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * 
     * @param pixels
     */
    public static void invert(int[][] pixels) {    
        	                
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * 
     * @param pixels
     */
    public static void highContrast(int[][] pixels) {
        
        	                
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * 
     * @param pixels
     */
    public static void greyScale(int[][] pixels) {
       
        //System.out.println("[ " + color.getRed() + ", " + color.getBlue() + ", " + color.getGreen());
        int avg = (color.getRed() + color.getBlue() + color.getGreen()) / 3;
        red = avg;
        green = avg;
        blue = avg;
        color = new Color(red, green, blue);
        //Setting new Color object to the image
        img.setRGB(x, y, color.getRGB());
                
  
             
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * 
     * @param out
     * @param pixels
     */
    public static void outputPPM(PrintWriter out, int[][] pixels) {
       
    }

    public static void something() {
        
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
    /**
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //edit choice
        String editChoice = args[0];
        String[] edits = {"-i", "-g", "-h"};

        String sourceFile = args[1];
        FileInputStream fis = new FileInputStream(sourceFile);
        in = new Scanner(fis);
        BufferedImage img = ImageIO.read(fis);

        if (editChoice.equals(edits[0])) {
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    getPixelValues(in);
                    if (color.getRed() >= 0 || color.getGreen() >= 0 || color.getBlue() >= 0) {
                        invert(pixels);
                    }
                }
            }
        }
        else if (editChoice.equals(edits[1])) {
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    getPixelValues(in);
                    if (color.getRed() >= 0 || color.getGreen() >= 0 || color.getBlue() >= 0) {
                        highContrast(pixels);
                    }
                }
            }
        }
        else if (editChoice.equals(edits[2])) {
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    getPixelValues(in);
                    if (color.getRed() >= 0 || color.getGreen() >= 0 || color.getBlue() >= 0) {
                        greyScale(pixels);
                    }
                }
            }
        }
        


        String targetFile = args[2];
        FileOutputStream fos = new FileOutputStream(targetFile);
        //PrintStream out = new PrintStream(fos);
        ImageIO.write(img, "jpg", fos);
        System.out.println("Done...");




        

        

        

        // Open the source file
       
        
        // Open the output file
        
        // Read the source file line-by-line and output them to the target file
       
        
    }
    
}
