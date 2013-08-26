package interface_approach;

public class Rectangle implements Shape {
	
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
        return area;
    }
    public double getPerimeter()
    {
    	double perimeter = (this.width * 2) + (this.length * 2);
        return perimeter;
    }
    
    public double getAPRatio()
    {
        return getArea()/getPerimeter();
    }

}
