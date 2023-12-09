package Ex.reflections;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Car c1 = (Car) CreatObject.createInstanceWithRandomString(new Car());
        System.out.println("Created instance with random car: " + c1.toString());
    }
}
