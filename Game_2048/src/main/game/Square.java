package game;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	int x,y,w,h;
	int contains = 0;
	int row;
	int col;
	Color color;
	
	//square constructor
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		this.w = 200;
		this.h = 200;
		this.x = this.col*this.w;
		this.y = this.row*this.h;
		//print random colors
		//this is just for testing
		int rand = (int) (Math.random()*3);
		contains = rand;
		this.setColor(rand);
		
		System.out.println("this color is " + this.color);
	}
	public void setColor(int contains) {
		//0 = nothing
		//1 = purple aka the x
		//2 = cyan aka 0
		switch(contains) {
		
		case 0:
			color = Color.black;
			break;
		case 1:
			color = Color.magenta;
			break;
		case 2:
			color = Color.cyan;
			break;

		}
	}
	
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, w, h);
		
	}
}
