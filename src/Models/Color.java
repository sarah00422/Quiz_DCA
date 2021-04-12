package Models;

public class Color {
	private int R; 
	private int G;
	private int B; 
	
	public Color (int _R, int _G, int _B) {
		this.R = _R;
		this.G = _G;
		this.B = _B;
	}
	
	public int[] getRGB() {
		int[] arr = {this.R, this.G, this.B};
		return arr;
	}
}
