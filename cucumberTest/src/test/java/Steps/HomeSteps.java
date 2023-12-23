package Steps;

import infra.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;


public class HomeSteps {
    SetUp setUp;

    @Given("Navigate to documentation page")
    public void navigateToDocumentation(){
        setUp = new SetUp("https://www.selenium.dev/documentation/");
    }


    @Then("get title of documentation page")
    public void getTitle() {
        this.setUp.getDriver().getTitle();
    }
    @After
    public void tearDown(){
        if (setUp != null) {
            setUp.getDriver().quit();
        }
    }

}
