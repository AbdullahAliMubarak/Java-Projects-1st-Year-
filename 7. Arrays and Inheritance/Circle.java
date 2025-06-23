/**
*Program to create a circle class that inherits the shape class
*Abdullah Ali Mubarak 
*ALMABD030
*/
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(Circle c) {
        super(c);
    }
    
    public Circle(String name, String colour, double radius) {
        super(name, colour);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + " Radius " + radius;
    }
}