import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Variables (instance & static)

  // Constuctor
  public ThisYear() {
    
  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
    // add this year code here
     drawStack(true);
    
  }

  // other methods


  private String[] images;
  private static final String blackBoarder = "download.png";

  public ThisYear(String[] images) {
    this.images = images;
  }
  
  /**
   * Creates a "stacking" animations with random angle rotations
   * of the image.
   */
  public void drawStack(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String image : images) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // black boarder - 5px offset all around
      if (hasBoarder) {
        double boarderHalfSize = (size + 10) / 2.0;
        int boarderX = (int)(centerX - (boarderHalfSize * Math.cos(radians) - boarderHalfSize * Math.sin(radians)));
        int boarderY = (int)(centerY - (boarderHalfSize * Math.sin(radians) + boarderHalfSize * Math.cos(radians)));
        drawImage(blackBoarder, boarderX, boarderY, size + 10, dAngle);
      }
      
      // image on top of black boarder (if drawn)
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }

}