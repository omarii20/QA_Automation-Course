package tests;

import infra.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.StatePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPlayer {
    private static WebDriver driver;
    private StatePage statePage;
    @Before
    public void setUp() {
        if (driver == null) {
            SetUp setUp = new SetUp();
            driver = setUp.getDriver();
        }
        this.statePage = new StatePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver instance
        }
    }

    @Given("User is on the leaders players page")
    public void navigateToLeadersPlayersPage() {
        driver.get("https://www.nba.com/stats/players/traditional");
    }

    @When("User filters by season {string}")
    public void filtersBySeason(String Season) {
        statePage.pickSeasonPlayer(Season);
    }

    @And("sorts by {string}")
    public void verifyTopPlayerPint(String Point) {
        String actualPlayerPoint = statePage.getPoint();
        assertEquals(actualPlayerPoint, Point);
    }

    @Then("Verify the top player is {string}")
    public void verifyTopTeam(String TopPlayer) {
        String actualTopPlayer = statePage.getFirstPlayer();
        assertEquals(actualTopPlayer, TopPlayer);
    }

}
