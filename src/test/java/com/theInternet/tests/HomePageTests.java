package com.theInternet.tests;

import com.theInternet.listeners.RetryAnalyzer;
import com.theInternet.listeners.TestListener;
import com.theInternet.pages.AddRemoveElements;
import com.theInternet.pages.HomePage;
import com.theInternet.testFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class HomePageTests extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAddElementFeature() {
        test = extent.createTest("Navigate to The ");
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
       AddRemoveElements addRemoveElements =  homePage.clickAddRemoveElements();
       Assert.assertEquals(addRemoveElements.getTitle(),"Add/Remove Elements");
      // Assert.assertEquals(addRemoveElements.getH3Text(),"Add/Remove Elements");
    }
}
