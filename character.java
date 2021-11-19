package javaApplication6;

import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class character {
	public ImageIcon[] imagecharacter = new ImageIcon[3];
	public int x;
	public int y;
	public int count = 0;
	
	character(){
		for(int i=0; i<imagecharacter.length; i++) {
			imagecharacter[i] = new ImageIcon(this.getClass().getResource("ninja"+(i+1)+".png"));
		}
		//this.x = x;
		//this.y = y;
	}
	public void move() {
		this.y-=1;
	}
	public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,45,45));
    }

}
