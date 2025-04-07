package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork14 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementBySimpleLocators() {
        // by id
        driver.findElement(By.id("flyout-cart"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("mob-menu-button"));
        driver.findElement(By.id("newsletter-subscribe-block"));
        driver.findElement(By.id("newsletter-email"));
        driver.findElement(By.id("newsletter-subscribe-button"));
        driver.findElement(By.id("subscribe-loading-progress"));
        driver.findElement(By.id("newsletter-result-block"));
        driver.findElement(By.id("ui-id-1"));
        driver.findElement(By.id("poll-block-1"));

        //by className
       driver.findElement(By.className("master-wrapper-page"));
       driver.findElement(By.className("master-wrapper-content"));
        driver.findElement(By.className("header"));
        driver.findElement(By.className("header-logo"));
        driver.findElement(By.className("header-links-wrapper"));
        driver.findElement(By.className("header-links"));
        driver.findElement(By.className("count"));
        driver.findElement(By.className("search-box"));
        driver.findElement(By.className("header-menu"));
        driver.findElement(By.className("language-selector"));


    }
}
