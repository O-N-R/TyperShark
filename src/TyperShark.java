import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TyperShark extends JFrame {

    public TyperShark() {

    	
    	Ocean ocean = new Ocean();
        add(ocean);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 768);
        
        setLocationRelativeTo(null);
        setTitle("TyperShark");
        setResizable(false);
        setVisible(true);
        ocean.getTextField().requestFocus();
    }

    public static void main(String[] args) {
        new TyperShark();
    }
}