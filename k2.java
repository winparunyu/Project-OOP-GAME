package javaApplication6;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;



public class k2 extends k1{
	Image image;
	
	k2(){
		String image1 = "k2.png";
		URL image2 = this.getClass().getResource(image1);
		image = Toolkit.getDefaultToolkit().getImage(image2);
		run.start();
	}
	Thread run = new Thread(new Runnable(){
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
					run.sleep(30);
				}catch(InterruptedException e){}
			}
		}
	});
	
    public Image getImage() {return image;}
	
	

}
