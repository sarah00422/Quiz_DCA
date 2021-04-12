import java.util.ArrayList;

import Controlers.FigureController;
import Models.CanvaElement;
import Models.Figure;
import processing.core.PApplet;


public class Main extends PApplet{
	FigureController controller;
	ArrayList<CanvaElement> objects;

	public static void main(String[] args) {
		 PApplet.main("Main");
		}
	@Override
	public void settings() {
	   size(900,800);
	   
	}
	
	@Override
	public void setup() {
		this.controller = new FigureController("config.txt", this);
		this.controller.initialize();
		this.objects = this.controller.getObjects();
	}
	@Override
	public void draw() {
		background(255);
		rectMode(CENTER);
		animateObjects();
	}
	
	public void mousePressed() {
		if (mouseButton==RIGHT){
			this.objects.add(this.controller.createRandomFigure());
		}
		
	}
	
	private void animateObjects() {
		for (int i = 0; i < this.objects.size(); i ++) {
			CanvaElement figure = this.objects.get(i);
			figure.hasCollied(this.objects);
			figure.draw();
			figure.move();
		}
	}
}