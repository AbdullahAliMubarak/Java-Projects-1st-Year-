/**
*Program to create a rectangle class that inherits the shape class
*Abdullah Ali Mubarak 
*ALMABD030
*/
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(Rectangle r) {
        super(r); 
    }
    
    public Rectangle(String name, String colour, double length, double width) {
        super(name, colour);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Length " + this.length + " Width " + this.width;
    }
}