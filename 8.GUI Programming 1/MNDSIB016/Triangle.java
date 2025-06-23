/* Student ID: MNDSIB016
 * Name: Sibahle Ntando
 * Surname: Mndebele
 * 28 September 2024
 * An extended class Triangle that inherits characteristics from the Shape.java class
*/

    import java.lang.Math;

    public class Triangle extends Shape{
        // Private Instance Variables
        private double side1;
        private double side2;
        private double side3;


    //constructors
    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //methods
    public boolean equals(Triangle t){
        return (side1==side1 && side2==side2 && side3==side3
        || side1==side1 && side2==side3 && side3==side2
        || side1==side2 && side2==side1 && side3==side3
        || side1==side2 && side2==side3 && side3==side1
        || side1==side3 && side2==side1 && side3==side2
        || side1==side3 && side2==side2 && side3==side1);     
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }
        
    public double getSide3() {
        return side3;
    }

    public void setSide1(double s){
        this.side1 = side1;
    }

    public void setSide2(double s){
        this.side2 = side2;
    }

    public void setSide3(double s){
        this.side3 = side3;
    }

    public double getArea() {
        // Method to calculate the area of a triangle using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        
        // Now apply Heron's formula
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle [" + super.toString()+",Side1=" + side1 +",Side2=" + side2 +",Side3=" + side3 + "]";
        }
    }