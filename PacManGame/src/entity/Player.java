package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler kh;
	
	int counter = 0;
	int choose = 1;
	
	final Image pacmanRight1, pacmanRight2, pacmanLeft1, pacmanLeft2, pacmanUp1, pacmanUp2, pacmanDown1, pacmanDown2;
	public Image pacman;
	
	public Player(GamePanel g, KeyHandler k){
		pacmanRight1 = new ImageIcon("resources/player/PacManRight1.png").getImage();
		pacmanRight2 = new ImageIcon("resources/player/PacManRight2.png").getImage();
		pacmanLeft1 = new ImageIcon("resources/player/PacManLeft1.png").getImage();
		pacmanLeft2 = new ImageIcon("resources/player/PacManLeft2.png").getImage();
		pacmanUp1 = new ImageIcon("resources/player/PacManUp1.png").getImage();
		pacmanUp2 = new ImageIcon("resources/player/PacManUp2.png").getImage();
		pacmanDown1 = new ImageIcon("resources/player/PacManDown1.png").getImage();
		pacmanDown2 = new ImageIcon("resources/player/PacManDown2.png").getImage();
		pacman=pacmanRight1;
		this.gp=g;
		this.kh=k;
		x = 100;
		y = 100;
		speed = 4;
	}
	
	public void update() {
		counter++;

		if(kh.upPressed) {
			y-=speed;
			if(choose == 1) 
				pacman=pacmanUp1;
			else
				pacman=pacmanUp2;
		}

		else if(kh.downPressed) {
			y+=speed;
			if(choose == 1) 
				pacman=pacmanDown1;
			else
				pacman=pacmanDown2;
		}

		else if(kh.rightPressed) {
			x+=speed;
			if(choose == 1) 
				pacman=pacmanRight1;
			else
				pacman=pacmanRight2;
		}

		else if(kh.leftPressed) {
			x-=speed;
			if(choose == 1) 
				pacman=pacmanLeft1;
			else
				pacman=pacmanLeft2;
		}

		if(counter == 10) {
			choose = 2;
		}
		if(counter == 20) {
			choose = 1;
			counter = 0;
		}
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(pacman, x, y, gp.tileSize, gp.tileSize, null);
	}
}
