package javaApplication6;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;


public class k1 {
	Image image;
	public int x = 0;
	public int y = (int)((Math.random()+550)) ;
	public int count = 0;
	
	k1(){
		String image1 = "k1.png";
		URL image2 = this.getClass().getResource(image1);
		image = Toolkit.getDefaultToolkit().getImage(image2);
		run.start();
	}
	Thread run = new Thread(new Runnable(){

		@Override
		public void run() {
			while(true) {
				x +=2;
				if(x >=1000) {
					image = null;
					run = null;
					x = -500;
					y = -500;
				}
				try {
					run.sleep(10);
				}catch(InterruptedException e){}
			}
			
		}
		
	});
	
	public Image getImage() {return image;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public Rectangle2D getbound() {
		return (new Rectangle2D.Double(x,y,45,45));
		}   //สร้างกรอบให้ object
	
}
