package javaApplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class gameover extends JPanel{
	private ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.jpg"));
	
	gameover(){
		setLayout(null);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameover.getImage(),0,0,1000,800,this);
		g.setColor(Color.RED);
		g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));
		g.drawString("GAME OVER",70,200);
	}

}
