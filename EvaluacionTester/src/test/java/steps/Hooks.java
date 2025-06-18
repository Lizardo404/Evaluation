package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks extends BasePage {
    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Scenario failing, please refer to the image attached to this report");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the error");
        }
    }
}

/*
Cucumber supports hooks, which are blocks of code that run before
or after each scenario. You can define them anywhere in your project
or step definition layers, using the methods @Before and @After.
Cucumber Hooks allows us to better manage the code workflow and helps
us to reduce the code redundancy. We can say that it is an unseen step,
which allows us to perform our scenarios or tests.
 */