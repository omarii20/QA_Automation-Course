package Ex.reflections;

public class Car {
    private String _Car;
    public Car(){}
    public Car(String carName){
        this._Car = carName;
    }

    @Override
    public String toString() {
        return "Object{Car=> " +"'"+ _Car +"'"+'}';
    }
}
