package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.QaPages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class QaSteps {
    public static WebDriver driver;
    public QaPages page1;
    @Given("MicroService Version")
    public void microserviceVersion() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://cloud-control-app.infra-sg.cld/microTracker");
        page1= new QaPages(driver);
    }

    @When("Enter environment name as {string}")
    public void enterVersionNameAs(String arg0) {
        page1.gettingEnvironment(arg0);

    }

    @Then("app name printed for null")
    public void appNamePrintedWhichHasNull() throws IOException {
        System.out.println("Printing Null environments");
        page1.gettingAppName();

    }
    @When("Find Mismatch environment for {string} and {string}")
    public void findMismatchEnvironmentForAnd(String arg0, String arg1) {
        page1.gettingEnvironment1(arg0,arg1);


    }
    @Then("app name printed for mismatch")
    public void appNamePrintedWhichHasMismatch() {
        System.out.println("Printing Mismatch environments");
        page1.gettingMismatch();


    }
}
