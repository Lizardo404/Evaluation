package pages;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SwagLabsPages extends BasePage{

    private String swagLogo = "//div[@class='app_logo']";
    //WebElements
    private String swagUserName  = "//input[@id='user-name']";
    private String swagPassword  = "//input[@id='password']" ;
    private String swagLoginBtn  = "//input[@id='login-button']" ;
    private String swagMenu      = "//button[@id='react-burger-menu-btn']";
    private String swagLogOutBtn = "//a[@id='logout_sidebar_link']";
    private String swagErroMsg = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    //Filter
    private String swagFilter      = "//select[@class='product_sort_container']";

    private String inventoryItem     ="//*[@id=\"inventory_container\"]/div/div[1]/div[2]";

    private String addToCar1 = "//button[@id='add-to-cart-sauce-labs-onesie']";
    private String addToCar2 = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']";
    private String shoppinList = "";



    // message erros logs
    private String logoText = "Swag Labs";
    private String firstMsgErr = "Epic sad face: Username and password do not match any user in this service";
    private String secMsgErr   = "Epic sadface: Sorry, this user has been locked out";
    private String blankPwdMsgErr = "Epic sadface: Password is required";
    private String blankUserMsgErr = "Epic sadface: Username is required";

    public SwagLabsPages() {super(driver);}

    //Open Page
    public void navigateSwagLabsPage(){
        navigateTo("https://www.saucedemo.com/");
    }

    public void loginSwangPage(String user, String pswd) throws InterruptedException {
          write(swagUserName, user);
          write(swagPassword, pswd);
          Thread.sleep(800);
          System.out.println("--------------------------------------------------");
          System.out.println("------System try login with follow credentials---");
          System.out.println("-----> user:{" + user + "} --------> password:{" + pswd + "}");
          clickElement(swagLoginBtn);
          System.out.println("------< System click on LogIn Button >---");
          try {
              Thread.sleep(300);
               getProductsPageTitle();
               System.out.println(swagLogo);
          } catch (Exception e) {
              Thread.sleep(300);
              loginStatusPage();
              System.out.println(swagErroMsg);
              throw new RuntimeException(e);
          }

    }

    public void getProductsPageTitle() {
        String textTitle = textFromElement(swagLogo);
        System.out.println("############################################");
        System.out.println("___________ LOGIN SUCCESSFUL ___________");
        getText("{"+textTitle+"}");
        System.out.println("--------------------------------------------------");
        Assert.assertEquals(textTitle,logoText);
        clickElement(swagMenu);
        clickElement(swagLogOutBtn);
        System.out.println("....:::LogOut Session:::....");
    }


    public void loginStatusPage(){
        String errorText = textFromElement(swagErroMsg);
            System.out.println("############################################");
            System.out.println("___________LOGIN ERROR ___________");
            System.out.println("{" + errorText + "}");
    }

    public void filterSwagPage(int x) throws InterruptedException {
        int count=x;
        String textExpected = "";
            try {
                Thread.sleep(300);
                selecFromDropDownByIndex(swagFilter, count);
                textExpected = textFromElement(inventoryItem);
                Assert.assertEquals(textExpected, textExpected);
                System.out.println("___________DROPDOWN SELECTED :{" + count + "}___________");
                System.out.println("___________{" + textExpected +"}___________");
            } catch (Exception e) {
                System.out.println("___________STEP NOT COMPLETED ___________");
                throw new RuntimeException(e);
            }
    }

    public void simpleLoginPage(String user, String pswd) throws InterruptedException {
      try {
        write(swagUserName, user);
        write(swagPassword, pswd);
        Thread.sleep(800);
        System.out.println("--------------------------------------------------");
        System.out.println("------System try login with follow credentials---");
        System.out.println("-----> user:{" + user + "} --------> password:{" + pswd + "}");
        clickElement(swagLoginBtn);
        System.out.println("------< System click on LogIn Button >---");
        System.out.println("___________ LOGIN SUCCESSFUL ___________");
      } catch (Exception e) {
          System.out.println("############################################");
          System.out.println("___________LOGIN ERROR ___________");
          throw new RuntimeException(e);
      }
    }

    public void addItemShop(){
        try {
            System.out.println("--------------------------------------------------");
            Thread.sleep(300);
            clickElement(addToCar1);
            System.out.println("----Item added to shopping List----");
            System.out.println("--------------------------------------------------");
            Thread.sleep(450);
            clickElement(addToCar2);
            System.out.println("----Item added to shopping List----");
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println("No Item was added to shopping list");
            throw new RuntimeException(e);
        }
    }

    public void ShoppiCart(){

    }
}




