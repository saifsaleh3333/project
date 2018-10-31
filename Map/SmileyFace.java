import java.io.*;

public class SmileyFace {
  public static void main (String [] args) {

    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.04);
    StdDraw.arc(0.5, 0.6, 0.4, 180, 0);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.12);
    StdDraw.point(0.7, 0.85);
    StdDraw.point(0.3, 0.85);
    double [] x = new double [3];
    x[0]=0.3;
    x[1]=0.5;
    x[2]=0.7;
 
    
    double [] y = new double [3];
    y[0]=0.55;
    y[1]=0.7;
    y[2]=0.55;
    StdDraw.setPenRadius(0.04);
    StdDraw.polygon(x,y);
    StdDraw.setPenRadius(0.015);
    StdDraw.circle(0.5, 0.5, 0.5);
    

  }
}
  