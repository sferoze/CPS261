package interface_approach;

public class Square implements Shape {

	private double side;
	
	Square(double s) 
	{
		this.side = s;
	}
	
	public double getArea()
    {
        double area = Math.pow(this.side, 2);
        return area;
    }
    public double getPerimeter()
    {
    	double perimeter = this.side * 4;
        return perimeter;
    }
    
    public double getAPRatio()
    {
        return getArea()/getPerimeter();
    }

}
