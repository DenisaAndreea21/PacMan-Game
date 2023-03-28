package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entity.Player;
import map.Map;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS 
	final int originalTileSize = 10; // 10x10 tile
	final int size = 4;
	public final int tileSize = size * originalTileSize; //40x40 tile

	final int screenColumns = 30;
	final int screenRows = 16;
	final int screenWidth = tileSize * screenColumns; //1200 pixels
	final int screenHeight = tileSize * screenRows; //640 pixels

	final int FPS = 60;
	Thread gameThread;
	KeyHandler kh = new KeyHandler();
	Player player = new Player(this,kh);
	Map map = new Map(this);
	
	GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(kh);
		this.setFocusable(true);
		
	}

	public void gameStartThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDraw = System.nanoTime() + drawInterval;

		while(gameThread != null) {

			player.update();
			repaint();

			try {
				double remainingTime = nextDraw - System.nanoTime();
				remainingTime/=1000000;
				if(remainingTime < 0)
					remainingTime = 0;
				Thread.sleep((long)remainingTime);

				nextDraw += drawInterval;
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		player.draw(g2d);
		map.draw(g2d);
		
		g2d.dispose();
	}
}
