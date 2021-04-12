package Models;

import java.util.ArrayList;

public interface CanvaElement {
	public void draw();
	public void move();
	public boolean hasCollied(ArrayList<CanvaElement> objects);
}
