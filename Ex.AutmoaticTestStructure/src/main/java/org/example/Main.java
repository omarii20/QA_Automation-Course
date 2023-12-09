//package Ex.AutmoaticTestStructure.src.main.java.org.example;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class Main {
//
//    public static void main(String[] args) {
//        ArrayList<Player> players = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            players.add(new Player("Player" + i, getRandomPosition(), getRandomNumber()));
//        }
//        players.add(new Player("Goalkeeper", FootBallTeam.Position.GOALKEEPER, getRandomNumber()));
//
//        FootBallTeam footballTeam = new FootBallTeam("TeamA", players);
//        footballTeam.getTeamMap().forEach((teamName, playerList) -> {
//            System.out.println("Team: " + teamName);
//            System.out.println("Players:");
//            playerList.stream()
//                    .forEach(player -> System.out.println("Name: " + player.get_Name()
//                            + ", Position: " + player.get_Position()
//                            + ", Number: " + player.get_Number()));
//            System.out.println();
//        });
//    }
//    private static int getRandomNumber(){
//        Random rand = new Random();
//        return rand.nextInt(99)+1;
//    }
//    private static FootBallTeam.Position getRandomPosition() {
//        FootBallTeam.Position[] positions = {FootBallTeam.Position.MIDFIELDER, FootBallTeam.Position.DEFENDER, FootBallTeam.Position.ATTACKER};
//        Random random = new Random();
//        return positions[random.nextInt(positions.length)];
//    }
//}
