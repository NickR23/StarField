import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class DrawingComponent extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7891322152673084522L;
	
	Timer worldT = new Timer(1,this);
	//Used to control which frame is being shown
	int framec = 0;
	
	int x = 10, y = 10, velx = 1,vely = 2;
	
	
BufferedImage[] backdrop = new BufferedImage[40];
BufferedImage astro;
    public void imageLoad () throws IOException{
	    	for(int i = 0; i<39; i++) {
	    		File file = new File("img/stars/"+i+".gif");
	    		backdrop[i] = ImageIO.read(file);
	    	}
    		File file = new File("img/stars/astronaut.png");
    		astro = ImageIO.read(file);
    }
    
	public void paintComponent (Graphics g) {
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
        //Runs the function to load in the images
        try {
           imageLoad();
        }   catch (IOException e) {
            System.out.println("Image failed to load");
        } 
        
        //Overflows framec back to init
		if(framec < 38) {
			framec+=1;
		}else {
			framec = 0;
		}
		
        g2d.drawImage(backdrop[framec],0,0,null);
        g2d.drawImage(astro,x,y,null);
        
		g2d.setColor(Color.BLACK);
		//Rectangle rect = new Rectangle (10,100,x,y);
		//g2d.fill(rect);
		worldT.start();

	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(x>getWidth()+50) {
			x =-100;
		}
		if(y>getWidth()+50) {
			y =-100;
		}
		
		x+=velx;
		y+=velx;
		System.out.println(framec);
		
		repaint();
	}
	
}
