package javaApplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class homegames extends JPanel {
	private ImageIcon background = new ImageIcon(this.getClass().getResource("background.jpg"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("start1.png"));
	JButton Jstart = new JButton(starts);
	
	homegames(){
		setLayout(null);
		//start1.setBounds(750,650,150,90);
		add(Jstart);
		Jstart.setBounds(340,360,345,80);
		add(Jstart);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(starts.getImage(),100,100,500,200,this);
		g.drawImage(background.getImage(),0,0,1000,800,this);
		g.setColor(Color.RED);
		g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));
		g.drawString("NINJA GAME",70,200);
		
	}

}
