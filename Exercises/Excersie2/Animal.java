package Exercises.Excersie2;

enum myAnimals{DOG, CAT, SHEEP, HORSE}
interface Animal {
    void move();
    String getGender();
    //int getId();
    double getWeight();
    Animal mate(Animal partner);
}

abstract class Animal_Abstract implements Animal{
    private static int _id=1;
    private final int _ID;
    private final String _gender;
    private final double _weight;

    protected Animal_Abstract(String g, double w){
        this._ID = _id++;
        this._gender = g;
        this._weight = w;
    }
    public int getID(){
        return _id;
    }
    public String getGender(){
        return _gender;
    }
    public double getWeight(){
        return _weight;
    }
}