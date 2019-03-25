import java.awt.event.*;
public class MouseManager implements MouseListener, MouseMotionListener
{
    private boolean pressed;
    private int x, y;
   
    public MouseManager(){
        pressed = false;
    }
    
    public boolean getPressed(){
        return pressed;
    }
    public int getMouseY(){
        return y;
    }
    public int getMouseX(){
        return x;
    }
    public void mouseClicked(MouseEvent e){
        
    }

    public void mouseEntered(MouseEvent e){
        
    }
    
    public void mouseExited(MouseEvent e){
        
    }
    
    public void mousePressed(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1){
            pressed = true;
        }
    }
    
    public void mouseReleased(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1){
            pressed = false;
        }
    }
    
    public void mouseDragged(MouseEvent e){
        
    }
    
    public void mouseMoved(MouseEvent e){
        x = e.getX();
        y = e.getY();
    }
}

