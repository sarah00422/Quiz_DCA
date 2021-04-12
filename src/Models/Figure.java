package Models;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Figure {
	private int size;
	private int posX;
	private int posY; 
	private int directionNumber; 
	private int value;
	protected Color color;
	protected PApplet app;
	protected int speedX;
	protected int speedY;
	protected Direction direction;
	
	public Figure (int _size, int _posX, int _posY, int _direction, int _value, Color _color, PApplet _app) {
		this.size = _size; 
		this.posX = _posX; 
		this.posY = _posY; 
		this.directionNumber = _direction; 
		this.value = _value;
		this.color = _color;	
		this.app = _app; 
		this.speedX = 5;
		this.speedY = 5;
		this.direction = this.setDirection();
	}
	
	private Direction setDirection() {
		if(this.directionNumber == 1 || this.directionNumber == 0) {
			return Direction.VERTICAL;
		} else if(this.directionNumber == -1) {
			return Direction.HORIZONTAL;
		} else {
			return Direction.DIAGONAL;
		}
	}
	
	protected void validateInBorders() {
		if(this.posX <= this.size/2 || this.posX >= (900 - this.size/2)) {
			this.speedX *= -1;
		}
		if(this.posY <= this.size/2 || this.posY >= (800 - this.size/2)) {
			this.speedY *= -1;
		}		
	}
	
	protected void displayValue() {
		app.fill(250);
		app.textSize(this.size/3);
		app.text(this.value, this.posX - (this.size/6), this.posY);
	}
	
	public boolean hasCollied(ArrayList<CanvaElement> objects) {
		boolean result = false;
		for(int i = 0; i < objects.size(); i++) {
			Figure object = (Figure) objects.get(i);
			int edgeX = this.posX + (this.size/2);
			int edgeY = this.posY + (this.size/2);
			boolean collitionX = (edgeX > (object.getPosX() - (object.getSize()/2)) && (edgeX < (object.getPosX() + (object.getSize()/2))));
			boolean collitionY = (edgeY > (object.getPosY() - (object.getSize()/2)) && (edgeY < (object.getPosY() + (object.getSize()/2))));
			if(collitionX && collitionY && !(object instanceof Triangle)) {
				Random random = new Random();
				Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
				Triangle triangle = new Triangle(random.nextInt(150), edgeX, edgeY, 2, this.value + object.value, color, this.app);
				objects.add(triangle);
				objects.remove(i);
				objects.remove((CanvaElement)this);
				result = true;
				break;
			}
		}
		return result;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getDirectionNumber() {
		return directionNumber;
	} 
    
	
}
