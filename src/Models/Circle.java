package Models;

import processing.core.PApplet;

public class Circle extends Figure implements CanvaElement {
	FiguresTypes type = FiguresTypes.CIRCLE;

	public Circle (int _size, int _posX, int _posY, int _direction, int _value, Color _color, PApplet _app) {
		super (_size, _posX, _posY, _direction, _value, _color, _app);
	}
	
	public void draw(){
	    int[] colorAr = this.color.getRGB(); 
		app.fill(colorAr[0], colorAr[1], colorAr[2]); 
		app.ellipse(this.getPosX(), this.getPosY(), this.getSize(), this.getSize());
	}
	
	public void move() {
		this.validateInBorders();
		if(this.direction == Direction.VERTICAL) {
			this.setPosY(this.getPosY() + this.speedY);	
		}
		if(this.direction == Direction.HORIZONTAL) {
			this.setPosX(this.getPosX() + this.speedX);
		}	
	}	
}

