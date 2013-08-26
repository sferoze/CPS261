package normal_class;

public class Circle extends Shape {
	
	private double radius;
	
	Circle(double r) 
	{
		this.radius = r;
	}
	
	public double getArea()
    {
        double area = Math.PI * Math.pow(this.radius, 2);
		//System.out.println("The area of the circle with radius " + this.radius + " is: " + area);
        return area;
    }
    public double getPerimeter()
    {
    	double circumference = Math.PI * 2 * this.radius;
    	//System.out.println("The circumference of the circle with radius " + this.radius + " is: " + circumference);
        return circumference;
    }

}
