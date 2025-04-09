package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork17 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    //создайте, пожалуйста, тестовый метод,
    // где вы будете искать те же 10 элементов на странице,
    // используя стратегию By.xpath

    @Test
    public void findElementByXpath() {
        //id -> xpath - //*[@id='value']
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        //tag -> xpath - //tag
        driver.findElement(By.xpath("//h2"));//7 elements

        //className -> xpath - //*[@class='value']
        driver.findElement(By.xpath("//div[@class='header']"));

        //text //*[contains(.,'Text')] - //poisk po tekstu po chastichnomu sovpadeniyu
        driver.findElement(By.xpath("//h2[contains(.,'you')]"));//3 elements

        //contains -> //*[text()='Text'] - poisk po tochnomu sovpadeniyu
        driver.findElement(By.xpath("//p[text()='Welcome to the new Tricentis store!']"));
        driver.findElement(By.xpath("//strong[text()='Popular tags']"));

        //srarts-with -> //*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//label[starts-with(@for,'po')]"));//4 elements

        //move up
        driver.findElement(By.xpath("//a[@class='ico-register']/.."));//li

        //parent - roditel'
        driver.findElement(By.xpath("//h3/parent::*"));
        driver.findElement(By.xpath("//h3/parent::div"));
        driver.findElement(By.xpath("//h3/.."));

        //ancestor - predki
        driver.findElement(By.xpath("//h3/ancestor::*"));
        driver.findElement(By.xpath("//h3/ancestor::div"));
        driver.findElement(By.xpath("//h3/ancestor::div[2]"));

        //following-sibling
        driver.findElement(By.xpath("//h3/following-sibling::*"));
    }
}
