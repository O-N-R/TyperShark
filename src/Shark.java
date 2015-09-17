
import java.awt.Image;




import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Shark{

    private int x, y;
    private String word;
    private Image image;
    boolean visible;
    String s;
    ImageIcon img;
    JPanel p;
    JLabel label;
    JLabel text;

    private int speed;

    public Shark(int x, int y, String word,int speed){
    	
    	ImageIcon ii = new ImageIcon(this.getClass().getResource("shark.png"));
    	image = ii.getImage();
    	
       visible = true;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.word = word;
   }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }
    public String getWord(){
    	
    	return word;
    	
    }
    public void setVisible(boolean b){
    	visible = b;
    
    }

    public void move() {
        x -= speed;
        if (x == 0){
            visible = false;
          Diver.getSharks().remove(this);
          Diver.die(false);
        }
    }
    
    
}