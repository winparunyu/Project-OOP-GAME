package javaApplication6;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class k3 extends k1{
	Image image;
	
	k3(){
		String image1 = "k3.png";
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
					run.sleep(20);
				}catch(InterruptedException e){}
			}
		}
	});
	
	public Image getImage() {return image;}

}
