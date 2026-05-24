package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

public class ExampleSteps {

    GooglePage googlePage = new GooglePage(Hooks.driver);

    @Given("I navigate to the example page")
    public void iNavigateToTheExamplePage() {
        googlePage.navegarAGoogle();
    }
}
