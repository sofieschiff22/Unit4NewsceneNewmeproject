import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // List of images read from text file, names match in assets
    String[] lastYearimages = FileReader.toStringArray("imageNames.txt");
    String[] thisYearimages = FileReader.toStringArray("imageNames2.txt");
    
    // Create scene objects
    LastYear lastYearScene = new LastYear(lastYearimages);
    ThisYear thisYearScene = new ThisYear(thisYearimages);

    // Call top level methods
    lastYearScene.drawScene();
    thisYearScene.drawScene();

    // Play scenes in theater
    Theater.playScenes(lastYearScene, thisYearScene);
    
  }
}