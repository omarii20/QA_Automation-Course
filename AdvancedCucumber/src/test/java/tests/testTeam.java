package tests;

import infra.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.StatePage;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testTeam {
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

    @Given("User is on the leaders teams page")
    public void navigateToLeadersTeamsPage() {
        driver.get("https://www.nba.com/stats/teams/traditional");
    }

    @When("Filter list by season {string}")
    public void filtersBySeason(String Season) {
        statePage.pickSeasonTeam(Season);
    }

    @Then("Verify the top team is {string}")
    public void verifyTopTeam(String TopTeam) {
        String actualTopTeam = statePage.getFirstTeam();
        assertEquals(actualTopTeam, TopTeam);
    }
}
