package abstract_class;

public class Square extends Shape {

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

}

