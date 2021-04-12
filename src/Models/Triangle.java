package Models;

import java.util.ArrayList;

import processing.core.PApplet;

public class Triangle extends Figure implements CanvaElement{
	FiguresTypes type = FiguresTypes.TRIANGLE;
	int x1; 
	int x2; 
	int x3; 
	int y1; 
	int y2; 
	int y3; 

	public Triangle (int _size, int _posX, int _posY, int _direction, int _value, Color _color, PApplet _app) {
		super (_size, _posX, _posY, _direction, _value, _color, _app);
	}
	
	public void draw(){
	    int[] colorAr = this.color.getRGB(); 
		app.fill(colorAr[0], colorAr[1], colorAr[2]); 
		this.x1 = this.getPosX() - (this.getSize()/2);
		this.y1 = this.getPosY() - (this.getSize()/2);
		this.x2 = this.getPosX();
		this.y2 = this.getPosY() + (this.getSize()/2);
		this.x3 = this.getPosX() + (this.getSize()/2);
		this.y3 = this.getPosY() - (this.getSize()/2);
		app.triangle(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
		this.displayValue();
	}
	
	public void move() {
		this.validateInBorders();
		this.setPosY(this.getPosY() + this.speedY);	
		this.setPosX(this.getPosX() + this.speedX);
	}

	@Override
	public boolean hasCollied(ArrayList<CanvaElement> objects) {
		return false;
	}

}