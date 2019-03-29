
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    public static int[] first() throws UnsupportedEncodingException, IOException {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("defaults.ini"), "utf-8"))) {
            //writer.println("Width:" + width + "\n" + "Height:" + height + "\n" + "ResetDefaults:false");
            writer.println("Width:" + width);
            writer.println("Height:" + height);
            writer.println("ResetDefaults:false");
        }
        return new int[]{width, height};
    }
    public static String rl(int n) throws IOException{
            return Files.readAllLines(Paths.get("defaults.ini")).get(n);
    }
    public static void main(String[] args) throws IOException {
        File f = new File("defaults.ini");
        boolean firstRun = true;
        String fs = null;
        if (f.length() != 0) {
            fs = new Scanner(f).useDelimiter("\\Z").next();
            firstRun = !(fs.substring(fs.length() - 5).equals("false"));
            System.out.println(fs.substring(fs.length() - 19) + "\n" + firstRun);
        }
        int[] dim;
        if (firstRun) {
            dim = first();
        } else {
            String w=rl(0);
            String h=rl(1);
            dim = new int[]{
                Integer.parseInt(w.substring(w.indexOf(":")+1)),
                Integer.parseInt(h.substring(h.indexOf(":")+1))};
        }
        Game game = new Game("oh boy", dim[0], dim[1]);
        game.start();
    }
}
