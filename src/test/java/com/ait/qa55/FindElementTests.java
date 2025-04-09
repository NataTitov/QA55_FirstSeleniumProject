package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        // find element by tag name
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        System.out.println(h1Element.getText());
        WebElement aElement = driver.findElement(By.tagName("a"));
        System.out.println(aElement.getText());

        //find list of elements by tag name
        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        for (int i = 0; i < aElements.size(); i++) {
            System.out.println(aElements.get(i).getText());

        }
        System.out.println(aElements.size());
    }

    @Test
    public void findElementBySimpleLocators() {
        // by id
        driver.findElement(By.id("city"));

        //by className
        driver.findElement(By.className("header"));
        System.out.println(driver.findElement(By.className("header")).getText());

        //by linkText
        driver.findElement(By.linkText("Let the car work"));

        //by partialLinkText - chasticnoe sovpadenie
        driver.findElement(By.partialLinkText("car"));
    }

    @Test
    public void findElementByCssSelector() { // bystriy, gibkiy, sostavnoy
        //tagName == css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> css(#)
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //className -> css(.)
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        //[attr='value']
        driver.findElement(By.cssSelector("[href='/registration?url=%2Fsearch']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='/registration']"));

        //start ->^
        driver.findElement(By.cssSelector("[href^='/reg']"));

        //end on ->$
        driver.findElement(By.cssSelector("[href$='/search']"));

        //tad + id - selectorHub
        driver.findElement(By.cssSelector("input#city"));

        //tad + class
        driver.findElement(By.cssSelector("div.mobile-header"));
        driver.findElement(By.cssSelector("div.search-card"));

        //tag + id + [attr = 'value']
        driver.findElement(By.cssSelector("input#city[type='text']"));

    }

    //*[@arrt='value']
    @Test
    public void findElementByXpath() {
        //id -> xpath - //*[@id='value']
        driver.findElement(By.xpath("//input[@id='city']"));

        //tag -> xpath - //tag
        driver.findElement(By.xpath("//h1"));

        //className -> xpath - //*[@class='value']
        //driver.findElement(By.className("header"));
        driver.findElement(By.xpath("//div[@class='header']"));

        //text //*[contains(.,'Text')] - //poisk po tekstu po chastichnomu sovpadeniyu
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));

        //contains -> //*[text()='Text'] - poisk po tochnomu sovpadeniyu
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

        //srarts-with -> //*[starts-with(@attr,'StartText')]
        //элемент <label>, у которого атрибут for начинается с текста "ci".
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        //move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        //parent - roditel'
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));

        //ancestor - predki
        driver.findElement(By.xpath("//h1/ancestor::*"));
        driver.findElement(By.xpath("//h1/ancestor::div"));
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));

        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::form"));

    }
}

