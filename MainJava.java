package javaApplication6;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class MainJava {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
        frame.setSize(1000,800);
        frame.setTitle("NINJA GAME");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //�Դ������
        frame.setResizable(false);
        //frame.setVisible(true);
        frame.setLocationRelativeTo(null);   //��������ç��ҧ
        //frame.add(new homegames());
        frame.setVisible(true);
        /*ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.green);
        */
   }

}
