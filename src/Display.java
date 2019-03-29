
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Display extends Canvas {

    private JFrame frame;
    private Canvas canvas;
    private int width, height, n, tempW, tempH;
    private boolean fsc = false;

    public Display(String title, int width, int height) {
        this.width = width;
        this.height = height;
        tempW = width;
        tempH = height;
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        createCanvas(width,height);
    }

    public void createCanvas(int width, int height) {
        canvas = new Canvas();
        Dimension dimensions = new Dimension(width, height);
        canvas.setPreferredSize(dimensions);
        canvas.setMaximumSize(dimensions);
        canvas.setMinimumSize(dimensions);
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }

    public void fullscreen(int tempX, int tempY, int f) {

        if (f%2==0) {
            System.out.println(f);
            frame.setVisible(true);
            frame.setBounds(tempX, tempY, tempW, tempH);
            frame.dispose();
            frame.setUndecorated(false);
            frame.setVisible(true);
            createCanvas(tempW,tempH);
        } else {
            frame.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
            frame.setUndecorated(true);
            frame.setVisible(true);
            createCanvas((int)screenSize.getWidth(),(int)screenSize.getHeight());
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getJFrame() {
        return frame;
    }
}
