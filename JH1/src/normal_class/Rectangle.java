package normal_class;

public class Rectangle extends Shape {
	
	private double width;
	private double length;
	
	Rectangle(double w, double l) 
	{
		this.width = w;
		this.length = l;
	}
	
	public double getArea()
    {
        double area = this.width * this.length;
		//System.out.println("The area of the rectangle with width " + this.width + " and length " + this.length + " is: " + area);
        return area;
    }
    public double getPerimeter()
    {
    	double perimeter = (this.width * 2) + (this.length * 2);
    	//System.out.println("The perimeter of the rectangle with width " + this.width + " and length " + this.length + " is: " + perimeter);
        return perimeter;
    }

}
