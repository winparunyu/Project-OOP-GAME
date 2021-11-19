package javaApplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;







public class StartGames extends JPanel implements ActionListener{
	character ch = new character();
	gameover gov = new gameover();
	homegames hg = new homegames();
	
	private ImageIcon startbackground1 = new ImageIcon(this.getClass().getResource("startbackground1.jpg"));
	private ImageIcon startbackground2 = new ImageIcon(this.getClass().getResource("startbackground2.jpg"));
	private ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.jpg"));
	private ImageIcon resume = new ImageIcon(this.getClass().getResource("resume.png"));
	private ImageIcon pause = new ImageIcon(this.getClass().getResource("pause.png"));
	
	ImageIcon restart = new ImageIcon(this.getClass().getResource("start.jpg"));
	JButton Startover = new JButton(restart);
	private JLabel score = new JLabel(); 
	
	public JButton resume1  = new JButton(resume);
	public JButton pause1  = new JButton(pause);
	
	public ArrayList<character> ch1 = new ArrayList<character>();
	public ArrayList<k1> knife1 = new ArrayList<k1>();
	public ArrayList<k2> knife2 = new ArrayList<k2>();
	public ArrayList<k3> knife3 = new ArrayList<k3>();
	public ArrayList<k4> knife4 = new ArrayList<k4>();
	
	
	public int time;
	public int HP = 5;
	public int score1 = 0;
	boolean timestart = true;
	boolean startknife = false;
	
	
	
	
	Thread gametime = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(15);
				}catch(Exception e) {}
				
				if(timestart == false) {
					repaint();
				}
			}
			
		}
		
	});
	
	Thread character = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(15);
				}catch(Exception e) {}
			}
			
		}
		
	});
	
	Thread k1 = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				try {
					if(startknife == false) {
						Thread.sleep((long)(Math.random()*10000)+2000);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(startknife == false) {
					knife1.add(new k1());
				}
			}
			
		}
		
	});
	
	Thread k2 = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				try{
					if(startknife ==false) {
						Thread.sleep((long)(Math.random()*10000)+2000);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(startknife == false) {
					knife2.add(new k2());
				}
			}
			
		}
		
	});
	
	Thread k3 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				try {
					if(startknife ==false) {
						Thread.sleep((long)(Math.random()*10000)+2000);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(startknife == false) {
					knife3.add(new k3());
				}
			}
		}
	});
	
	Thread k4 = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				try {
					if(startknife == false) {
						Thread.sleep((long)(Math.random()*10000)+2000);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				if(startknife == false) {
					knife4.add(new k4());
				}
			}
			
		}
		
	});
	
	Thread timegame = new Thread(new Runnable() {

		@Override
		public void run() {
			while(true) {
				if(timestart == false) {
					time = (time-1) ;
				}
				try {
					Thread.sleep(1000);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	});
	

		
	
	StartGames(){
		this.setFocusable(true);     //จะมีเมาส์ไป Focus ข้างใน JPanel
		this.setLayout(null);
		resume1.setBounds(850,100,40,40);
		pause1.setBounds(850,30,40,40);
		
		resume1.addActionListener(this);
		pause1.addActionListener(this);
		this.add(resume1);
		this.add(pause1);
		this.add(score);
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int a = e.getKeyCode();
				//if(a==KeyEvent.VK_A)
				if(a ==KeyEvent.VK_LEFT) {
					ch.x -=10;
					//ch.count++;
				}
				else if(a ==KeyEvent.VK_RIGHT){
					ch.x +=10;
					//ch.count++;
				}
				
				if(ch.count >3) {
					ch.count = 0;
				}
				else if(a ==KeyEvent.VK_UP) {
					ch.count = 5;
					
				}
			}
			public void keyReleased(KeyEvent e) {
				ch.count=0;
			}
		});
		
		ch.x = 500;
		gametime.start();
		character.start();
		timegame.start();
		k1.start();
		k2.start();
		k3.start();
		k4.start();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(time <=0 || HP <=0) {
			this.remove(resume1);
			this.remove(pause1);
			this.setLayout(null);
			g.drawImage(gameover.getImage(),0,0,1000,800,this);
			g.setColor(Color.WHITE);
			g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,50));
			g.drawString("SCORE   "+score1,380,200);
			
		//=========state2==========	
		}else if(time <=50) {
			g.drawImage(startbackground2.getImage(),0,0,1000,800,this);
			g.drawImage(ch.imagecharacter[ch.count].getImage(),ch.x,550,110,160,this);
			
			//======หลุดกรอบ=======
			if(ch.x<0) {
				ch.x = this.getWidth()-10;
			}
			if(ch.x>this.getWidth()) {
				ch.x=20;
			}
			
  		    
			//====knife1====
			for(int i = 0; i<knife1.size(); i++) {
				g.drawImage(knife1.get(i).getImage(), knife1.get(i).getX(), knife1.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife1.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife1.get(j).getbound())) {
						knife1.remove(j);
						ch1.remove(i);
						HP = HP-1;
						score1 -=20;
						g.drawString("-1HP",ch.x+100,580);
						g.drawString("-20",ch.x+100,650);
					}
				}
			}
			
			//====knife2====
			for(int i = 0; i<knife2.size(); i++) {
				g.drawImage(knife2.get(i).getImage(), knife2.get(i).getX(), knife2.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife2.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife2.get(j).getbound())) {
						knife2.remove(j);
						ch1.remove(i);
						HP = HP-2;
						score1 -=30;
						g.drawString("-2HP",ch.x+100,580);
						g.drawString("-30",ch.x+100,650);
					}
				}
			}
			
			//====knife3====
			for(int i = 0; i<knife2.size(); i++) {
				g.drawImage(knife3.get(i).getImage(), knife3.get(i).getX(), knife3.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife3.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife3.get(j).getbound())) {
						knife3.remove(j);
						ch1.remove(i);
						HP = HP-3;
						score1 -=40;
						g.drawString("-3HP",ch.x+100,580);
						g.drawString("-40",ch.x+100,650);
					}
				}
			}
			
			//======knife4=======
			for(int i = 0; i<knife4.size(); i++) {
				g.drawImage(knife4.get(i).getImage(), knife4.get(i).getX(), knife4.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife4.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife4.get(j).getbound())) {
						knife4.remove(j);
						ch1.remove(i);
						HP = HP + 2;
						score1 +=30;
						g.drawString("+2HP",ch.x+100,580);
						g.drawString("+30",ch.x+100,650);
					}
				}
			}
			
			g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,30));
			g.setColor(Color.WHITE);
			g.drawString("SCORE =  "+score1,80, 100);
			g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,30));
			g.drawString("Time "+time,335,150);
			g.drawString("HP  "+HP,100,200);
			
		
			//=========state1===========
			
		}else {
			g.drawImage(startbackground1.getImage(),0,0,1000,800,this);
			g.drawImage(ch.imagecharacter[ch.count].getImage(),ch.x,550,110,160,this);
			
			//======หลุดกรอบ=======
			if(ch.x<0) {
				ch.x = this.getWidth()-10;
			}
			if(ch.x>this.getWidth()) {
				ch.x=20;
			}
			
			/*for(int i=0;i<ch1.size();i++) {
				character ba = ch1.get(i);
	  		    //g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
	  		    ba.move();
	  		    ba.count++;
	  		    if(ba.y<0){
	  		    	ch1.remove(i);
	  		    }
			}*/
			
			//====knife1====
			for(int i = 0; i<knife1.size(); i++) {
				g.drawImage(knife1.get(i).getImage(), knife1.get(i).getX(), knife1.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife1.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife1.get(j).getbound())) {
						knife1.remove(j);
						ch1.remove(i);
						HP = HP-1;
						score1 -=20;
						g.drawString("-1HP",ch.x+100,580);
						g.drawString("-20",ch.x+100,650);
					}
				}
			}
			
			//====knife2====
			for(int i = 0; i<knife2.size(); i++) {
				g.drawImage(knife2.get(i).getImage(), knife2.get(i).getX(), knife2.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife2.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife2.get(j).getbound())) {
						knife2.remove(j);
						ch1.remove(i);
						HP = HP-2;
						score1 -=30;
						g.drawString("-2HP",ch.x+100,580);
						g.drawString("-30",ch.x+100,650);
					}
				}
			}
			
			//====knife3====
			for(int i = 0; i<knife3.size(); i++) {
				g.drawImage(knife3.get(i).getImage(), knife3.get(i).getX(), knife3.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife3.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife3.get(j).getbound())) {
						knife3.remove(j);
						ch1.remove(i);
						HP = HP-3;
						score1 -=40;
						g.drawString("-3HP",ch.x+100,580);
						g.drawString("-40",ch.x+100,650);
					}
				}
			}
			
			//======knife4=====
			for(int i = 0; i<knife4.size(); i++) {
				g.drawImage(knife4.get(i).getImage(), knife4.get(i).getX(), knife4.get(i).getY(),100,100,this);
			}
			for(int i = 0; i<ch1.size(); i++) {
				for(int j=0; j<knife4.size(); j++) {
					if(Intersect(ch1.get(i).getbound(), knife4.get(j).getbound())) {
						knife4.remove(j);
						ch1.remove(i);
						HP = HP + 2;
						score1 +=30;
						g.drawString("+2HP",ch.x+100,580);
						g.drawString("+30",ch.x+100,650);
					}
				}
			}
			
			g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,30));
			g.setColor(Color.BLACK);
			g.drawString("SCORE =  "+score1,80, 100);
			g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,30));
			g.drawString("Time "+time,335,150);
			g.drawString("HP  "+HP,100,200);
			
		}
	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Startover) {
			this.setSize(1000,800);
			this.add(hg);
			this.setLocation(null);
			timestart = true;
			startknife = true;
		}
		
	}
	

}
