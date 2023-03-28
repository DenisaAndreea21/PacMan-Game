package map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

import main.GamePanel;

public class Map {
	
	GamePanel gp;
	
	Image wall = new ImageIcon("resources/tiles/wall.png").getImage();
	
	private static String pathname ="resources/maps/map";
	File fisier = new File(pathname);
	
	public Map(GamePanel g){
		this.gp = g;
	}
	
	public void draw(Graphics2D g) {
		FileReader intrare;
		try {
			intrare = new FileReader(fisier);
			BufferedReader bufferedReader1 = new BufferedReader(intrare);
			int row = 0;
			while(bufferedReader1.ready()){
				String linie = bufferedReader1.readLine();
				for(int i=0;i<linie.length();i++) {
					if(linie.charAt(i)=='1') {
						g.drawImage(wall, i*gp.tileSize, row*gp.tileSize, gp.tileSize, gp.tileSize, null);
					}
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
