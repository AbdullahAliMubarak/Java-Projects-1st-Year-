/* Program to create a shape circle 
 * Abdullah Ali Mubarak
 * 30 Sep 2024
*/
import java.lang.Math;

public class Circle extends Shape {
    //Instance Variables 
    private double radius;

    //constructors
    public Circle(){
    }
    
    public Circle(double r) {
        super();
        this.radius = r;
    }

    public Circle(double r, String c, boolean f) {
        super(c, f);
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public boolean equals(Circle c) {
        return this.radius == c.radius;
    }

    @Override
    public String toString(){
        return "Circle [" + super.toString() + ", radius=" + radius + "]";
    }

}