import java.io.* ;
import java.util.Scanner;
public class ElectionI {
  public static void main (String [] args) throws FileNotFoundException{
    /* 
     * Collaboration: I got help with Mr Superdock through email over the weekend. I also used a few online resources to learn more about canvases and their aspect ratios. From this 
     * i learned for a map to look nice, it should have a 1:1 aspect ratio. I utilized that fact in my code. That is all my collaboration.
     * */
    
    String regionName = args[0] ;
    String typeOfMap = args[1] ;
      File regionFile = new File( regionName + ".txt") ;
      Scanner fileScanner = new Scanner(regionFile) ;
      double minLong = fileScanner.nextDouble() ;
      double minLat = fileScanner.nextDouble() ;
      double maxLong = fileScanner.nextDouble() ;
      double maxLat = fileScanner.nextDouble() ;
      double longDistance = Math.abs(minLong - maxLong);
      double latDistance = Math.abs( minLat-maxLat) ;
      double differenceLatLong = Math.abs(longDistance-latDistance) ;
      if ( longDistance >= latDistance) {
        StdDraw.setXscale(minLong,maxLong) ;
        StdDraw.setYscale(minLat - (differenceLatLong/2) , maxLat + (differenceLatLong/2)) ;
      }
      else if ( latDistance>= longDistance) {
        StdDraw.setXscale(minLong- (differenceLatLong/2),maxLong + (differenceLatLong/2)) ;
        StdDraw.setYscale(minLat , maxLat) ;
      }
                          
        
      int numberOfSubRegions = fileScanner.nextInt() ;
      fileScanner.nextLine() ;
      fileScanner.nextLine() ;
      double republicanVotes;
      double democraticVotes;
      double thirdPartyVotes;
      for (int y =1 ; y<= numberOfSubRegions; y++) {
        String nameOfSubRegion = fileScanner.nextLine() ;
        republicanVotes = fileScanner.nextInt() ;
        democraticVotes = fileScanner.nextInt() ;
        thirdPartyVotes= fileScanner.nextInt();
        fileScanner.nextLine();
        int numberOfPoints = fileScanner.nextInt();
        double[] arrayOfXPoints = new double[numberOfPoints] ;
        double[] arrayOfYPoints = new double[numberOfPoints] ;
        fileScanner.nextLine() ;
        for ( int x =0;x<= numberOfPoints-1;x++) {
          arrayOfXPoints[x] = fileScanner.nextDouble() ;
          arrayOfYPoints[x] = (fileScanner.nextDouble())  ;
          fileScanner.nextLine(); 
        }
        if ( typeOfMap.equals("White")) {
          StdDraw.polygon(arrayOfXPoints, arrayOfYPoints) ;
          if(fileScanner.hasNextLine()){
            fileScanner.nextLine();
          }
        }
        else if (typeOfMap.equals("RedBlue")) {
          if ( democraticVotes > republicanVotes && democraticVotes > thirdPartyVotes) {
            StdDraw.setPenColor(StdDraw.BLUE) ;
            StdDraw.filledPolygon(arrayOfXPoints,arrayOfYPoints) ;
            if(fileScanner.hasNextLine()){
              fileScanner.nextLine();
            }
          }
          else if ( republicanVotes > democraticVotes && republicanVotes > thirdPartyVotes) {
            StdDraw.setPenColor(StdDraw.RED) ;
            StdDraw.filledPolygon(arrayOfXPoints,arrayOfYPoints) ;
            if(fileScanner.hasNextLine()){
              fileScanner.nextLine();
            }
          }
          else if ( thirdPartyVotes > democraticVotes && thirdPartyVotes > republicanVotes) {
            StdDraw.setPenColor(StdDraw.GREEN) ;
            StdDraw.filledPolygon(arrayOfXPoints,arrayOfYPoints) ;
            if(fileScanner.hasNextLine()){
              fileScanner.nextLine();
            }
          }
        }
        else if( typeOfMap.equals("Purple")) {
          double totalVotes = democraticVotes + republicanVotes + thirdPartyVotes;
          double democraticColorPercentage =((democraticVotes/totalVotes) *100);
          double republicanColorPercentage =((republicanVotes/totalVotes) *100);
          double thirdPartyColorPercentage =((thirdPartyVotes/totalVotes) *100);
          int democraticColorAmount= (int)((democraticColorPercentage *255) / (100));
          int republicanColorAmount= (int)((republicanColorPercentage *255) / (100));
          int thirdPartyColorAmount= (int)((thirdPartyColorPercentage *255) / (100));
          StdDraw.setPenColor(republicanColorAmount,thirdPartyColorAmount,democraticColorAmount);
          StdDraw.filledPolygon(arrayOfXPoints,arrayOfYPoints) ;
          if(fileScanner.hasNextLine()){
            fileScanner.nextLine();
          }
        }
      }

      
      

      
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}