
public class Sphere implements Solids {
	
	private double radius;
	private String name,color;
	
	public Sphere(double radius,String color, String name){
		this.radius = radius;
		this.name = name;
        this.color = color;
        
		
	}
	
	//Volume = 4/3*pi*r^3
	public double getVolume(){
		return (4/3)*Math.PI*radius*radius*radius;
	}
	public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
	
}
