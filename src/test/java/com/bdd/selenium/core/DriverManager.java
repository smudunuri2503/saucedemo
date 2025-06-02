package com.bdd.selenium.core;

import com.bdd.selenium.core.DriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {


    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
