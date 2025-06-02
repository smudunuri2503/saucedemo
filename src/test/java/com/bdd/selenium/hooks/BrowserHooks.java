package com.bdd.selenium.hooks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bdd.selenium.core.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.aventstack.extentreports.ExtentTest;
import com.bdd.selenium.utils.ExtentManager;
import io.cucumber.java.*;

public class BrowserHooks {

    private final DriverManager driverManager;

// Cucumber injects this DriverManager
public BrowserHooks(DriverManager driverManager) {
    this.driverManager = driverManager;
}
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set BrowserStack capabilities
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("bstack:options", new HashMap<String, Object>() {{
            put("os", "Windows");
            put("osVersion", "11");
            put("sessionName", "My Selenium Test"+LocalDateTime.now() ); // optional
            put("local", "false"); // if you want to test local servers, set true and configure local testing
        }});

        // Your BrowserStack credentials
        String USERNAME = "sindhum_Dev8tJ";
        String AUTOMATE_KEY = "GYJ874anexA7XqV1q1tC";

        WebDriver driver = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub"), caps);

        driverManager.setDriver(driver);
        // driver.get("https://www.saucedemo.com/");
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = ExtentManager.createTest(scenario.getName());
        scenario.log("Test Started: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentManager.getTest().fail("Step failed: " + scenario.getStatus());
        } else {
            ExtentManager.getTest().pass("Step passed");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentManager.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentManager.getTest().pass("Scenario passed");
        }
        ExtentManager.flush();
    }


    @After
    public void tearDown() {
        WebDriver driver = driverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
