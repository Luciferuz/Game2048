package Package;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput {

    public static JFrame finalMenu = new JFrame();

    public KeyboardInput() {
        finalMenu.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                System.out.println(evt.getKeyCode());
                System.exit(1);
            }
        });

    }


}
