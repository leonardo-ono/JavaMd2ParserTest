package view;

/**
 * Keyboard class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 */
public class Keyboard {
    
    private boolean[] keysDown = new boolean[256];
    
    public Keyboard() {
    }

    public void set(Integer keycode, Boolean down) {
        keysDown[keycode] = down;
    }
    
    public boolean isDown(Integer keycode) {
        return keysDown[keycode];
    }

    public boolean isUp(Integer keycode) {
        return !keysDown[keycode];
    }
    
}
