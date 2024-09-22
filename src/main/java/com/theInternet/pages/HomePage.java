package com.theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final By addRemoveElements = By.linkText("Add/Remove Elements");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddRemoveElements clickAddRemoveElements() {
         driver.findElement(addRemoveElements).click();
         return new AddRemoveElements(driver);
    }
}
