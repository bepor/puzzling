
import java.awt.event.*;
import javax.swing.event.*;

public class KeyManager implements KeyListener {

	 private boolean[] keys;
	 public boolean up, down, left, right, space;

	 public void update() {
		  up = keys[KeyEvent.VK_W];
		  down = keys[KeyEvent.VK_S];
		  left = keys[KeyEvent.VK_A];
		  right = keys[KeyEvent.VK_D];
		  space = keys[KeyEvent.VK_SPACE];
	 }

	 public KeyManager() {
		  keys = new boolean[256];
	 }

	 public void keyPressed(KeyEvent e) {
		  keys[e.getKeyCode()] = true;
	 }

	 public void keyReleased(KeyEvent e) {
		  keys[e.getKeyCode()] = false;
	 }

	 public void keyTyped(KeyEvent e) {

	 }
}
