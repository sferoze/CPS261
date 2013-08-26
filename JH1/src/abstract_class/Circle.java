package abstract_class;

public class Circle extends Shape {

	private double radius;
	
	Circle(double r) 
	{
		this.radius = r;
	}
	
	public double getArea()
    {
        double area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }
    public double getPerimeter()
    {
    	double circumference = Math.PI * 2 * this.radius;
        return circumference;
    }

}
