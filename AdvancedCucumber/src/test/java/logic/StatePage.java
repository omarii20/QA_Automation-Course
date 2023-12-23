package logic;

import org.openqa.selenium.WebDriver;

public class StatePage {
    private final TeamSection teamSection;
    private final PlayerSection playerSection;

    public StatePage (WebDriver driver){
        this.teamSection = new TeamSection(driver);
        this.playerSection= new PlayerSection(driver);
    }
    public void pickSeasonTeam(String season){
        teamSection.selectSeason(season);
    }
    public void pickSeasonPlayer(String season){
        playerSection.selectSeason(season);
    }
    public String getFirstTeam(){
        return teamSection.getTopTeamName();
    }
    public String getFirstPlayer(){
        return playerSection.getTopPlayerName();
    }
    public String getPoint(){
        return playerSection.getPlayerPoint();
    }
}
