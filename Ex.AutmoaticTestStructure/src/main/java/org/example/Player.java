package Ex.AutmoaticTestStructure.src.main.java.org.example;

import javax.swing.text.Position;

public class Player {
    private String _Name;
    private FootBallTeam.Position _Position;
    private int _Number;

    public String get_Name() {return _Name;}
    public String get_Position() {return _Position.toString();}
    public int get_Number() {return _Number;}
    public FootBallTeam.Position getPosition() {return _Position;}
    public Player(String name, FootBallTeam.Position p, int n){
        this._Name = name;
        this._Position = p;
        this._Number = n;
    }
}
