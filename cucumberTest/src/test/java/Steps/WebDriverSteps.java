package Steps;

import infra.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import logic.WebDriverPage;

public class WebDriverSteps {
    SetUp setUp;
    WebDriverPage webDriverPage;

    @Given("Navigate to home page")
    public void navigateToHomeDocumentation(){
        setUp = new SetUp("https://www.selenium.dev/documentation/");
    }

    @When("click web driver link")
    public void clickToWebDriverPage (){
        webDriverPage = new WebDriverPage(this.setUp.getDriver());
        this.webDriverPage.clickToNavigateWebDriverPage();
    }
    @And("click web elements link")
    public void getWebDriverPage(){
        webDriverPage = new WebDriverPage(this.setUp.getDriver());
        this.webDriverPage.clickToNavigateWebElementsPage();
    }
    @Then("navigate to web elements page")
    public void getWebElementsPage() {
        System.out.println(setUp.getDriver().getTitle());
    }

}
