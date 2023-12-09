package Exercises.Excersie1;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        System.out.println(c1.area());

        Rectangle r1 = new Rectangle(5,6);
        System.out.println(r1.area());

        Square s1 = new Square(5);
        System.out.println(s1.area());

        ///////example of first code ///////
        // Figure f1 = new Figure(5,6);
        // System.out.printf(String.valueOf(f1.area()));
    }
}
