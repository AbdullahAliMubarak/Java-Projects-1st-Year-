/* Student ID: MNDSIB016
 * Name: Sibahle Ntando
 * Surname: Mndebele
 * 28 September 2024
 * An extended class Circle that inherits characteristics from the Shape.java class
*/

import java.lang.Math;

public class Circle extends Shape {
    // Private Instance Variables 
    private double radius;

    //constructors
    public Circle(){
    }
    
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public boolean equals(Circle color) {
        return this.radius == color.radius;
    }

    @Override
    public String toString(){
        return "Circle [" + super.toString() + ", radius=" + radius + "]";
    }

}