package com.theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElements {

    private WebDriver driver;
    private final By pageTitle = By.tagName("h3");

    public AddRemoveElements(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public String getH3Text()
    {
        return driver.findElement(pageTitle).getText();
    }
}
