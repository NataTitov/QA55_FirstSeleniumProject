package com.ait.qa55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().to("https://google.com");
        driver.navigate().back();
    }

    @Test
    public void openGooleTest(){
        System.out.println("Hello!");
    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

}
