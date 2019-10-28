
public class Cuboid implements Solids {

	private double length, width, height;
	private String name,color;
	
	public Cuboid(double length, double width, double height, String color, String name){
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = color;
		this.name = name;
	}
	
	//Volume = length*width*height
	public double getVolume(){
		return length*width*height;
	}
	public String getName() {
	    return name;
	}
	public String getColor() {
	    return color;
	}
	
}
