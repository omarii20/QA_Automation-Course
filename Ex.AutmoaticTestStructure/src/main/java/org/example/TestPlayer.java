package Ex.AutmoaticTestStructure.src.main.java.org.example;

import java.util.ArrayList;
import java.util.List;

public class TestPlayer {
    // if at least two player have a same number, return true
    public static boolean playersHaveSameNumbers(ArrayList<Player> players) {
        long distinctNumbersCount = players.stream().map(Player::get_Number).distinct().count();
        long totalPlayersCount = players.size();
        return distinctNumbersCount == totalPlayersCount;
    }
    // return true if more than one player have goalkeeper position
    public static boolean hasMoreThanOneGoalkeeper(List<Player> players) {
        long numberOfGoalkeepers = players.stream()
                .filter(player -> player.getPosition() == FootBallTeam.Position.GOALKEEPER)
                .count();
        return numberOfGoalkeepers > 1;
    }
}

