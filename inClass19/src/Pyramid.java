
public class Pyramid implements Solids {

	private double length, width, height;
	private String name,color;

	
	public Pyramid(double length, double width, double height, String color, String name) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.name = name;
        this.color = color;
	}
	
	//Volume = length*width*height/3
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
