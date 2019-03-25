import java.awt.*;
import java.io.*;
import java.util.*;
public class Launcher {
	 public static int[] first() throws UnsupportedEncodingException, IOException{
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  int width = (int) screenSize.getWidth();
		  int height = (int) screenSize.getHeight();
		  try(PrintWriter writer = new PrintWriter(new OutputStreamWriter(
					 new FileOutputStream("defaults.ini"),"utf-8"))) {
				writer.println("ran"+"\n"+"Width:"+width+"\n"+"Height:"+height+"\n"+"ResetDefaults:false");
		  }
		  return new int[]{width,height};
	 }
	 public static void main(String[] args) throws IOException {
		  File f = new File("defaults.ini");
        boolean firstRun = true;
         String fs = null;
        if (f.length()!=0) {
		   fs = new Scanner(f).useDelimiter("\\Z").next();
		   firstRun = !(fs.substring(fs.length()-19).equals("ResetDefaults:false"));
		   System.out.println(fs.substring(fs.length()-19) +"\n"+ firstRun);
        }
		  int[] dim;
		  if(firstRun){
				dim=first();
		  }else{
				dim = new int[]{Integer.parseInt(fs.substring(fs.indexOf("Width:")+6, fs.indexOf("Height:")-1)) , Integer.parseInt(fs.substring(fs.indexOf("Height:")+7, fs.indexOf("ResetDefaults:false")-1))};
		  }
		  Game game = new Game("Game", dim[0], dim[1]);
		  game.start();
	 }
}
