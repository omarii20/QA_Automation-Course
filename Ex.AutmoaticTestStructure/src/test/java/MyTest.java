package Ex.AutmoaticTestStructure.src.test.java;
import Ex.AutmoaticTestStructure.src.main.java.org.example.FootBallTeam;
import Ex.AutmoaticTestStructure.src.main.java.org.example.Player;
import Ex.AutmoaticTestStructure.src.main.java.org.example.TestPlayer;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

public class MyTest {
    private ArrayList<Player> players;
    private static FootBallTeam footballTeam;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            players.add(new Player("Player" + i, FootBallTeam.getRandomPosition(), FootBallTeam.getRandomNumber()));
        }
        players.add(new Player("Goalkeeper", FootBallTeam.Position.GOALKEEPER, FootBallTeam.getRandomNumber()));
        footballTeam = new FootBallTeam("TeamA", players);
    }

    @Test
    public void testMoreThanOneGoalkeeper() {
        Assertions.assertFalse(TestPlayer.hasMoreThanOneGoalkeeper(players));
    }

    @Test
    public void testPlayersHaveSameNumbers() {
        Assertions.assertTrue(TestPlayer.playersHaveSameNumbers(players));
    }

    @AfterEach
    public void tearDown() {
        players.clear();
        footballTeam = null;
    }
}
