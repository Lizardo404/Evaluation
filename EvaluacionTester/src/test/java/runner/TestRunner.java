package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",// directory from .features files
        glue = "steps",// packeges where we hava steps files
        plugin = {"pretty","html:target/cucumber-reports"},
        tags = "@searchFiltersDemo"
)


public class TestRunner {
    @AfterClass
    public static void cleanDriver() //Clear webdriver variable
    {
        BasePage.closeBrowser();  //System will close browser after testing finished
    }
}
