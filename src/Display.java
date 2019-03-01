
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display extends Canvas {

	 private JFrame frame;
	 private Canvas canvas;
	 private int width, height;

	 public Display(String title, int width, int height) {
		  this.width = width;
		  this.height = height;
		  frame = new JFrame();
		  frame.setTitle(title);
		  frame.setSize(width, height);
		  frame.setResizable(false);
		  frame.setLocationRelativeTo(null);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  createCanvas();
	 }

	 public void createCanvas() {
		  canvas = new Canvas();
		  Dimension dimensions = new Dimension(width, height);
		  canvas.setPreferredSize(dimensions);
		  canvas.setMaximumSize(dimensions);
		  canvas.setMinimumSize(dimensions);
		  canvas.setFocusable(false);
		  frame.add(canvas);
		  frame.pack();
	 }

	 public Canvas getCanvas() {
		  return canvas;
	 }

	 public JFrame getJFrame() {
		  return frame;
	 }
}
