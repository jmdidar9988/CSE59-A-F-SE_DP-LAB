

public class Main{
    public static void main(String[] args ) { Shape myRectangle = new Rectangle(5,10);
    Shape myCircle = new Circle(3);
    Shape myTriangle = new Triangle(4,5);
    Shape[] myShapes = { myRectangle, myCircle, myTriangle };


AreaCalculator calculator = new AreaCalculator();
double totalArea = calculator.calculateTotalArea(myShapes);

System.out.println("The total area of all shapes is: " + totalArea);
}
}



interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    public double length;
    public double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (radius * radius);
    }
}

class Triangle implements Shape {
    public double base;
    public double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea(){
        return 0.5 * base *height;
    }
}


class AreaCalculator{
    public double calculateTotalArea(Shape[] shapes){
        double area =0;
        for (Shape shape : shapes){
            area += shape.calculateArea();
            
        }
        return area;
    }
} 


