package Ex.AutmoaticTestStructure.src.main.java.org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FootBallTeam {
    private String _TeamName;
    HashMap<String, ArrayList<Player>> listTeam;
    public enum Position {MIDFIELDER,DEFENDER,ATTACKER,GOALKEEPER}
    public FootBallTeam(String teamName, ArrayList<Player> players){
        this.listTeam = new HashMap<>();
        this._TeamName = teamName;
        this.listTeam.put(_TeamName, players);
    }
    public HashMap<String, ArrayList<Player>> getTeamMap() {return listTeam;}
    public static int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(99)+1;
    }
    public static Position getRandomPosition() {
        FootBallTeam.Position[] positions = {FootBallTeam.Position.MIDFIELDER, FootBallTeam.Position.DEFENDER, FootBallTeam.Position.ATTACKER};
        Random random = new Random();
        return positions[random.nextInt(positions.length)];
    }
    public static Position getGoalKeeper() {
        return Position.GOALKEEPER;
    }
}
