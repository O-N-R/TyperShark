import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Diver extends Thread{

    private String diver = "diver.png";
    private int level = 1;
    private int depth = 0;
    private Image image;
    private static ArrayList<Shark> sharks;
    private static boolean alive = true;
    
    private ArrayList<String> words;

    public Diver() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(diver));
        image = ii.getImage();
        sharks = new ArrayList<Shark>();
        words = new ArrayList<String>();
        try{
        words =  getWords();
        }catch(Exception e){}
    }


   

    public Image getImage() {
        return image;
    }

    public static ArrayList<Shark> getSharks() {
        return sharks;
    }


    public void fire() {
    	Random rand = new Random();
    	int index;
    	
    	index = rand.nextInt(words.size());
    	String word = words.get(index);
    	
    	System.out.println(index);
    
    	
    	if(sharks.size()<=level){
    	switch(rand.nextInt(4)){
    	
    	case 0: sharks.add(new Shark(2000,70,word,rand.nextInt(4)+1));
    			words.remove(index);
    		break;
    	case 1:	sharks.add(new Shark(2000,210,word,rand.nextInt(4)+1));
    			words.remove(index);
    		break;
    	case 2:	sharks.add(new Shark(2000,350,word,rand.nextInt(4)+1));
    			words.remove(index);
    		break;
    	case 3:	sharks.add(new Shark(2000,490,word,rand.nextInt(4)+1));
    			words.remove(index);
    		break;
    		
    	
    	}
    	}
       
    	
    }
    public void run(){
    	
    	while(true){
    	try{
    		sleep(1000);
    	}catch(Exception e){}
    	if(depth%1000 == 0)
    		level++;
    	fire();
    	
    	if(depth % 500 == 0)
    		level++;
    	
    	depth+= 100;
    	}
    	
    }

    
    public int getDepth(){
    	return depth;
    	
    }
    
    public static void die(boolean d){
    	
    	alive = d;
    	
    }
    public ArrayList<String> getWords() throws Exception{
    	
    	ArrayList<String> words = new ArrayList<String>();
    	
    	BufferedReader Read = new BufferedReader(new FileReader("word.txt"));
    	String line = Read.readLine();
    	while (line != null){
    		words.add(line);
    		line = Read.readLine();
    		
    	}
    		Read.close();
    	
    	return words;
    	
    }
    
}