package steps;
import io.cucumber.java.en.*;
import pages.SwagLabsPages;

public class SwagLabsSteps {
        SwagLabsPages swaglabs = new SwagLabsPages();

    @When("the user navigate to saucedemo page")
    public void navigateSauceDemo() {
        swaglabs.navigateSwagLabsPage();
    }

    @Given("add {word} and {word} to login saucedemo")
    public void UserLoginSaucedemo(String user, String pswd) throws InterruptedException {
        swaglabs.loginSwangPage(user,pswd);
    }

    @When("filter products by different methods")
    public void filterProductsByMethods() throws InterruptedException {
        for (int count = 0; count < 4; count++) {
            swaglabs.filterSwagPage(count);
            System.out.println("["+count+"]");
        }
    }



    @Given("user login to Swag labs page")
    public void userLoginToSwagLabsPage() throws InterruptedException {
        String user = "standard_user";
        String pswd = "secret_sauce";
        swaglabs.simpleLoginPage(user,pswd);
    }

    @When("filter products by low price methods")
    public void filterProductsByLowPriceMethods() throws InterruptedException {
        int count = 3;
        swaglabs.filterSwagPage(count);
    }

    @And("add first Item filter to shopping cart")
    public void addFirstItemFilterToShoppingCar(){
         swaglabs.addItemShop();
    }

    @Then("verify shopping cart")
    public void verifyShoppingCart() {
    }


}
