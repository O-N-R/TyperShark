
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;








import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;






public class Ocean extends JPanel implements ActionListener {

    private Timer timer;
    private Diver diver;
    private JTextField jt = new JTextField(30);
    private String input;
    private int score = 0;


	public Ocean() {
    	
    	//addKeyListener(new TAdapter());
        setFocusable(true);
       
       // setBackground(Color.BLUE);
       
        setDoubleBuffered(true);
        jt.setToolTipText("Enter");
        jt.addKeyListener(new keyListen());
        
        add(jt);

        diver = new Diver();
        diver.start();
        
       
        timer = new Timer(5, this);
        timer.start();
    }


	
	public void paintComponent(Graphics g){
		
		ImageIcon icon = new ImageIcon("background.jpg");
        Image img = icon.getImage();
		
		
		super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
		
		
	}
    public void paint(Graphics g) {
    	
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(diver.getImage(),10 ,10, this);

        ArrayList<Shark> ms = diver.getSharks();

        for (int i = 0; i < ms.size(); i++ ) {
            Shark s = (Shark) ms.get(i);
            g2d.drawImage(s.getImage(), s.getX(), s.getY(), this);
            Font font = new Font("Serif", Font.PLAIN, 80);
            g2d.setFont(font);
            g2d.drawString(s.getWord(), s.getX() + 20,s.getY() + 150);
        }
        
        
       
        
        Font font = new Font("Serif", Font.PLAIN, 50);
        g2d.setFont(font);
        g2d.drawString(Integer.toString(score),1500,50);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        ArrayList<Shark> ms = diver.getSharks();

        
        for (int i = 0; i < ms.size(); i++) {
            Shark s= (Shark) ms.get(i);
            if (s.isVisible()) 
                s.move();
            else ms.remove(i);
        }

        repaint(); 
        
    }
    
    public JTextField getTextField(){
    	
    	return this.jt;
    }
        
    

	
	private class keyListen implements KeyListener{
		
		private int temp;
	       	 
            @Override
            public void keyTyped(KeyEvent event) {
            }
         
            @Override
            public void keyReleased(KeyEvent event) {
            }
         
            @Override
            public void keyPressed(KeyEvent e){
            	
           	 int key = e.getKeyCode();
           	 int i = 0;
           	 
           	try{
           	    AudioInputStream audioInputStream =
           	        AudioSystem.getAudioInputStream(
           	            this.getClass().getResource("type.wav"));
           	    Clip clip = AudioSystem.getClip();
           	    clip.open(audioInputStream);
           	    clip.start();
           	}
           	catch(Exception ex){}
           	
           	
           	
        	
                if (key == KeyEvent.VK_ENTER) {
                    input = jt.getText();
                    jt.setText("");
                    
                   	 for(i=0;i<(diver.getSharks().size());i++)
                   	 {
                   		temp = score;
                   		 if(input.compareTo(diver.getSharks().get(i).getWord()) == 0)
                   		 {
                   			diver.getSharks().get(i).setVisible(false);
                   				
                          	 score += diver.getSharks().get(i).getWord().length();
                          	try{
                          	    AudioInputStream audioInputStream2 =
                          	        AudioSystem.getAudioInputStream(
                          	            this.getClass().getResource("zap.wav"));
                          	    Clip clip2 = AudioSystem.getClip();
                          	    clip2.open(audioInputStream2);
                          	    clip2.start();
                          	}
                          	catch(Exception ex){}
                   			 
                   			break;
                   		 }
                   			 
                   		 
                   	 }
                   	 
                   	 if(temp == score){
                   		 System.out.println("here");	
                   		try{
                      	    AudioInputStream audioInputStream3 =
                      	        AudioSystem.getAudioInputStream(
                      	            this.getClass().getResource("wrong.wav"));
                      	    Clip clip3 = AudioSystem.getClip();
                      	    clip3.open(audioInputStream3);
                      	    clip3.start();
                      	}
                      	catch(Exception ex){}
                   	 }
                   	 
                   	
                   	 
                   	 
                   	 
                   
                   	 
                    }
                
                 
                
                if (key == KeyEvent.VK_A)
                	add(new JLabel("a"));
                
            }
        }
		
	}

	
    
   /* private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            diver.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            diver.keyPressed(e);
        }
    }*/

