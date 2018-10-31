

import java.io.*;
import java.util.Scanner;

public class Election {
  public static void main (String [] args) throws FileNotFoundException, IllegalArgumentException{
    
    String first = args[0];
    String second = args [1];
    //This is so that the user only has to enter the region
    String fileName = first + ".txt";
    //initializes a file and scanner
    File stateFile = new File(fileName);
    Scanner scannerName = new Scanner(stateFile);
     
    

   //gets the latitude and longitude from the file
   double minLongitude = scannerName.nextDouble();
   double minLatitude = scannerName.nextDouble();
   scannerName.nextLine();
   //saves maximum long and lat
   double maxLongitude = scannerName.nextDouble();
   double maxLatitude = scannerName.nextDouble();
   scannerName.nextLine();
   //getting the parameters for the map
   Double q = (maxLongitude-minLongitude);
   Double r = (maxLatitude - minLatitude);
   if (q > r) {
   double n = (q-r);
   // draws the map
   StdDraw.setXscale(minLongitude, maxLongitude);
   StdDraw.setYscale(minLatitude - (n /2), maxLatitude + (n/2));
 } else if (r > q) {
   double m = (r-q);
   StdDraw.setXscale(minLongitude - (m/2), maxLongitude + (m/2));
   StdDraw.setYscale(minLatitude, maxLatitude);


     }else{
StdDraw.setXscale(minLongitude, maxLongitude);
    StdDraw.setYscale(minLatitude, maxLatitude);
     }
    int places = scannerName.nextInt();
    scannerName.nextLine();
    scannerName.nextLine();
    
   
    
    while (scannerName.hasNextLine()) {
      
    //gets the name of the state     
    String state = scannerName.nextLine();
    // number of democratic and republican votes
    int repub = scannerName.nextInt();
    int democ = scannerName.nextInt();
    int indep = scannerName.nextInt();
    scannerName.nextLine();
    int corners = scannerName.nextInt();
    scannerName.nextLine();
      
    //uses the corners of the map as an array 
    double[] x = new double[corners];
    double[] y = new double[corners];
    
    for (int i = 0; i<x.length; i++) {
      
      x[i] = scannerName.nextDouble();
      y[i] = scannerName.nextDouble();
      scannerName.nextLine();
    }
      //sets the color to red or blue depending on the number of votes for each candidate
      if (second.equals("RedBlue")) {
      if (repub>democ) {
      StdDraw.setPenColor(StdDraw.RED);
      
    } else if (democ>repub) {
      StdDraw.setPenColor(StdDraw.BLUE);
      
    } else {
      StdDraw.setPenColor(StdDraw.GREEN);
    }
      StdDraw.filledPolygon(x, y);
          
    }
    
    
    // draws a plain white map
    if (second.equals("White")) {
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.polygon(x, y);
      
      
    }
    //draws a purple map with a shade that depends on the votes
    if (second.equals("Purple")) {
        double repubdouble = repub + 0.0;
        double reddouble = (repubdouble / (repub + democ + indep)) *255;
        double bluedouble = (democ / (repubdouble + democ + indep)) *255;
        double greendouble = (indep / (repubdouble + democ + indep)) *255;
        int red = (int) reddouble;
        int blue = (int) bluedouble;
        int green = (int) greendouble;
        StdDraw.setPenColor(red, green, blue);
        StdDraw.filledPolygon(x, y);
      }


    if (scannerName.hasNextLine() == true) {
      scannerName.nextLine();
  }
}
    
  }
}





