package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
  //  private static Actions actions;
    Actions actions = new Actions(driver);

    //un solo valor para todas las instancias del objeto, una sola instancia compartida para todas las clases
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); //wait explicit
    //webdriver esperara hasta 10' en la pagina hasta encontrar los webelements

    static {  // block static to open browser
        WebDriverManager.chromedriver().setup(); // call webdriver
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) { // code to execute one time at the first to run script
        BasePage.driver = driver;
    }

    //Static method to navigate a URL,  url --> argument to get web address
    public static void navigateTo(String url) {
        driver.get(url);
        WebDriverManager.chromedriver().setup(); // call to execute we  bdriver ASA chromeDriver
        driver.manage().window().maximize();
    }

    // close browser
    public static void closeBrowser(){
        driver.quit();
        System.out.println("###################  Browser was closes by code  ##############");
    }
    //
    //Framework to selenium!! Find Element by webdriver
    // Framework to reuse code only programing one time
    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));  //objetc to webelement return a waitelement until condition completed
    }   //ExpectedConditions --> attach import org.openqa.selenium.support.ui.ExpectedConditions;

    //instruction to clic on webElemeny
    public void clickElement (String locator){ // click element to recall on pageobjet class
        Find(locator).click();
    }

    public void selecFromDropDownByValue(String locator, String valueSelected){
        Select dropDownFromCountry = new Select(Find(locator));
        dropDownFromCountry.selectByValue(valueSelected);
    }


    public void selecFromDropDownByIndex(String locator, int valueSelected){
        Select dropDownFromCountry = new Select(Find(locator));
        dropDownFromCountry.selectByIndex(valueSelected);
    }

    public int dropDownSize(String locator){
        Select dropDown = new Select(Find(locator));
        List<WebElement> dropDownOptions = dropDown.getOptions(); // agarra todas las opciones que tiene el DP en una lista
        return dropDownOptions.size(); //devuelve la cantidad de opciones dentro del DP
    }

    public void selectRadioButton(String locator){
        Select radioButton = new Select(Find(locator));
    }

    //Action to mouse
    public void hoverOverElement(String locator){
        actions.moveToElement(Find(locator)).perform();
    }

    //Write text
    //instruction to clear and write on textbox webelement
    public void write(String locator, String keyToSent){   //Wi will share string argument
        Find(locator).clear();
        Find(locator).sendKeys(keyToSent);
        Find(locator).sendKeys(Keys.ENTER);
    }

   public String getText(String locator){   // clase para obtener el textValor dentro de un WebElement
       String getTextFromElement = "";
        getTextFromElement = Find(locator).getAttribute("value");
       //  getTextFromElement = Find(locator).getAttribute(getTextFromElement);
       return getTextFromElement;

   }

    //obtener valores de un dropdown
    public List<String> getValueFromDD(String locator){
        Select dropDownFromCountry = new Select(Find(locator));
        //obtener todos los valores en una lista del tipo webelement
        List<WebElement> dDOptions = dropDownFromCountry.getOptions();
        // Generamos la lista y la guardamos en un Array de tipo texto
        List<String> values = new ArrayList<>();
        for (WebElement options:dDOptions){
            values.add(options.getText());
        }
        return values;
    }

    //Funcion tipo String que nos devolvera un texto

    public String textFromElement(String locator) {
      return Find(locator).getText(); //Devuelve el texto de un WebElement, siempre y cuando tenga texto elemento si no tirara una excepcion

    }


//   public String validateText(String locator, String textToValidate){
//       Assert.assertEquals(textToValidate,Find(locator).getText());
//       return locator;
//   }
// this funtion should not be on bagepage, it shoudl be on steps page
}
