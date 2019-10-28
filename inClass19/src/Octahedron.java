
public class Octahedron implements Solids{
	
	private double edge;
	private String name,color;
	
	public Octahedron(double edge, String color, String name){
		this.edge = edge;
		this.name = name;
		this.color = color;
	}
	
	//Volume sqrt(2)/3 times edge^3
	public double getVolume(){
		return Math.sqrt(2)*(edge*edge*edge)/3;
	}
	public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
	
}
