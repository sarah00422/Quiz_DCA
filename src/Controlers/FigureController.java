package Controlers;
import java.util.ArrayList;
import java.util.Random;

import Models.CanvaElement;
import Models.Circle;
import Models.Color;
import Models.Square;
import processing.core.PApplet;



public class FigureController {
	String filePath;
	PApplet app;
	ArrayList<CanvaElement> objects;
	Random random;
	
	public FigureController(String _path, PApplet _app) {
		this.filePath = _path;
		this.app = _app;
	}
	
	public void initialize() {
		//1. read the file
		this.random = new Random();
		this.objects = new ArrayList<CanvaElement>();
		String[] lines = app.loadStrings(this.filePath);
		//2. create the different objects depending on the file´s specification 
		for(int i = 0 ; i < lines.length ; i++) {
			String[] data = lines[i].split(" ");
			this.objects.add(this.createFigure(data));
		}
	}
	
	private CanvaElement createFigure(String[] data)  {
		CanvaElement figure;
		Color color = new Color(this.random.nextInt(256), this.random.nextInt(256), this.random.nextInt(256));
		if(data[0].equals("Square")) {
			Square square = new Square(Integer.parseInt(data[1]), 
									   Integer.parseInt(data[2]), 
									   Integer.parseInt(data[3]), 
									   Integer.parseInt(data[4]), 
									   Integer.parseInt(data[5]),
									   color, 
									   this.app);
			figure = square;
		} else if (data[0].equals("Circle")) {
			Circle circle = new Circle(Integer.parseInt(data[1]), 
					   				   Integer.parseInt(data[2]), 
					   				   Integer.parseInt(data[3]), 
					   				   Integer.parseInt(data[4]), 
					   				   Integer.parseInt(data[5]),
					   				   color, 
					   				   this.app);
			figure = circle;
		} else {
			figure = (CanvaElement) new Object();
		}
		return figure;
	} 
	
	public CanvaElement createRandomFigure() {
		Color color = new Color(this.random.nextInt(256), this.random.nextInt(256), this.random.nextInt(256));
		int val = random.nextInt(101);
		int randSize = random.nextInt(100);
		int randPosX = random.nextInt(750);
		int randPosY = random.nextInt(750);
		int randDirection = random.nextInt(2 + 1) - 1;
		int randValue = random.nextInt(100);
		if(val >= 50) {
			return new Square(randSize, randPosX , randPosY, randDirection , randValue, color, this.app);
		} else {
			return new Circle(randSize, randPosX , randPosY, randDirection , randValue, color, this.app);
		}
	}

	public ArrayList<CanvaElement> getObjects() {
		return objects;
	}
	
}
