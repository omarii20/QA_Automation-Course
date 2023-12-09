package Exercises.Excersie1;
abstract class Figure {
    abstract double area();
}
class Circle extends Figure {
    private final double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    double area() {
        return Math.PI * (radius * radius);
    }
}
class Rectangle extends Figure {
    private final double length;
    private final double width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    double area() {
        return length * width;
    }
}
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}

/////////////////////////////////////////////// Given excercise 1 Code ///////////////////////////////////////////////

//class Figure {
//    enum Shape { RECTANGLE, CIRCLE };
//
//    // Tag field - the shape of this figure
//    final Shape shape;
//
//    // These fields are used only if shape is RECTANGLE
//    double length;
//    double width;
//
//    // This field is used only if shape is CIRCLE
//    double radius;
//
//    // Constructor for circle
//    Figure(double radius) {
//        shape = Shape.CIRCLE;
//        this.radius = radius;
//    }
//
//    // Constructor for rectangle
//    Figure(double length, double width) {
//        shape = Shape.RECTANGLE;
//        this.length = length;
//        this.width = width;
//    }
//
//    double area() {
//        switch(shape) {
//            case RECTANGLE:
//                return length * width;
//            case CIRCLE:
//                return Math.PI * (radius * radius);
//            default:
//                throw new AssertionError(shape);
//        }
//    }
//}