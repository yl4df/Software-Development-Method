public class Circle {
    
	private double radius;
	private Point center;
	
	public Circle() {
		radius = 1;
		center = new Point(0,0);
	}
	
	public Circle(double radius, Point center) {
		this.radius = radius;
		//this.center = center;
		this.center = new Point(center);
	}
	
	@Override
	public String toString() {
		return "Center: " + center + " Radius: " + radius;
	}
	
	public boolean contains(Point p) {
		double distance = center.distance(p);
		if(distance <= radius) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Point p = new Point(3,3);
		Circle c = new Circle(3, p);
		System.out.println(c);
		p.setX(15);
		System.out.println(c);
		
		Point p1 = new Point(4,5);
		Circle c1 = new Circle(4, p1);
		Circle c2 = c1;
		System.out.println(c1.equals(c2));
		
		Point p3 = new Point(4,5);
		Circle c3 = new Circle(4, p3);
		Point p4 = new Point(p3);
		Circle c4 = new Circle(4,p4);
		System.out.println(c3.equals(c4));
		
		Point p5 = new Point(3,5);
		Circle c5 = new Circle(4, p5);
		Point p6 = new Point(2,5);
		Circle c6 = new Circle(3, p6);
		System.out.println(c5.equals(c6));

	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0) {
			this.radius = radius;
		}
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public boolean equals(Object o) {
		if(o != null && o instanceof Circle) {
			Circle otherCircle = (Circle) o;
			if(this.radius == otherCircle.getRadius() &&
					this.center.equals(otherCircle.center)){
				return true;
			}
		}
		return false;
	}
	

}
