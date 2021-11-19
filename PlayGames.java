package javaApplication6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;




public class PlayGames extends JFrame implements ActionListener{
	homegames homegames1 = new homegames();
	StartGames startgames1 = new StartGames();
	gameover gameover1 = new gameover();
	
	public PlayGames(){
		setSize(1000,800);
		this.add(homegames1);
		//this.add(gameover1);
		//this.add(startgames1);
		homegames1.Jstart.addActionListener(this);
		startgames1.resume1.addActionListener(this);
		startgames1.pause1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//add(startgames1);
		if(e.getSource()== homegames1.Jstart) {
			this.setLocationRelativeTo(null);
			this.remove(homegames1);
			this.setSize(1000,800);
            this.setSize(1000,800);
            this.add(startgames1);
            startgames1.requestFocusInWindow();
            startgames1.timestart = false;
            startgames1.HP = 5;
            startgames1.score1 = 0;
            startgames1.time = 100;
            startgames1.startknife = false;
            startgames1.timestart = false;
            
		}else if(e.getSource() == startgames1.resume1) {
			this.setLocationRelativeTo(null);
			this.setSize(1000,800);
			this.add(startgames1);
			startgames1.requestFocusInWindow();
			startgames1.timegame.resume();
			startgames1.gametime.resume();
			startgames1.character.resume();
			startgames1.k1.resume();
			startgames1.k2.resume();
			startgames1.k3.resume();
			startgames1.k4.resume();
		}else if(e.getSource() == startgames1.pause1) {
			this.setLocationRelativeTo(null);
			this.setSize(1000,800);
			this.add(startgames1);
			startgames1.requestFocusInWindow();
			startgames1.timegame.suspend();
			startgames1.gametime.suspend();
			startgames1.character.suspend();                               
			startgames1.k1.suspend();
			startgames1.k2.suspend();
			startgames1.k3.suspend();
			startgames1.k4.suspend();
		}
		this.validate();
        this.repaint();
		
	}
	
	public static void main(String[] args) {
		JFrame jf = new PlayGames();
        jf.setSize(1000,800);
        jf.setTitle("NINJA GAME");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
}    
    
}
