package com.bdd.selenium.stepdefinitions;

import io.cucumber.java.en.*;

// import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
// import io.github.bonigarcia.wdm.WebDriverManager;

import com.bdd.selenium.core.DriverManager;
// import com.bdd.selenium.hooks.BrowserHooks;
import com.bdd.selenium.utils.ExtentManager;

public class saucelabs {

    private final WebDriver driver;

    public saucelabs(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    @Given("the url is launched")
    public void urlislaunched()
    {
        driver.get("https://www.saucedemo.com/");

    }
    @When("I login with valid user {string} and {string}")
    public void openGoogleHomepage(String username, String password) {
        // WebDriver driver = BrowserHooks.getDriver();
        ExtentManager.getTest().info("entering username valid ");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        ExtentManager.getTest().info("entering password valid ");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        
        ExtentManager.getTest().info("click on login ");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).build().perform();

    }

    @Then("the search results should contain {string}")
    public void verifySearchResults(String expectedText) {

        WebElement results = driver.findElement(By.cssSelector("[data-test='title']"));
        ExtentManager.getTest().info("verifying the login behaviour");
        Assert.assertTrue(results.getText().toLowerCase().contains(expectedText.toLowerCase()),
                "Search results do not contain expected text: " + expectedText);
        driver.quit();
    }
}
