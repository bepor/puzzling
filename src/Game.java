
import java.awt.*;
import java.awt.image.*;

public class Game implements Runnable {

    //Window Variables
    private String title;
    private int width, height,n;
    //Runnable Variables
    private boolean running;
    private boolean fbool=true;

    private Thread thread;

    //Graphics
    private Graphics g;
    private BufferStrategy bs;
    private Display display;

    //User Input Variables
    private MouseManager mouseManager;
    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        mouseManager = new MouseManager();
        keyManager = new KeyManager();
    }

    public void init() {
        display = new Display(title, width, height);
        display.getJFrame().addKeyListener(keyManager);
        display.getJFrame().addMouseListener(mouseManager);
        display.getJFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }

    public void update() {
        keyManager.update();
        if (keyManager.f11) {
            if(!fbool){
                fbool=true;
                n++;
                display.fullscreen(display.getJFrame().getX(), display.getJFrame().getY(), n);
            }
        } else{
            fbool=false;
        }
}

    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        bs.show();
        g.dispose();
    }

    public void run(){
        init();
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now, lastTime = System.nanoTime();
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            lastTime = now;
            if (delta >= 1){
                update();
                render();
                delta--;
            }
        }        
    }

    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if (!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
