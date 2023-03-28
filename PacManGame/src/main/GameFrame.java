package main;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GamePanel gp = new GamePanel();
	GameFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("PacMan");
		this.add(gp);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		gp.gameStartThread();
	}
}
