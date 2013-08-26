package normal_class;

public class Square extends Shape {

	private double side;
	
	Square(double s) 
	{
		this.side = s;
	}
	
	public double getArea()
    {
        double area = Math.pow(this.side, 2);
		//System.out.println("The area of the square with side length " + this.side + " is: " + area);
        return area;
    }
    public double getPerimeter()
    {
    	double perimeter = this.side * 4;
    	//System.out.println("The perimeter of the square with side length " + this.side + " is: " + perimeter);
        return perimeter;
    }

}
