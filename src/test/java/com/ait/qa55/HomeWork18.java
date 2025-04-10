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

public class HomeWork18 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table_style.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByXpath() {
        //find element by xpath
        //move up
        driver.findElement(By.xpath("//a[@class='ico-register']/.."));//div class='w3-col l10 m12'

        //parent - roditel'
        driver.findElement(By.xpath("//h1/parent::*"));//div
        driver.findElement(By.xpath("//h1/parent::div"));

        //ancestor - predki
        driver.findElement(By.xpath("//h1/ancestor::*"));//7 elements

        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::*"));//34 elements

        //preceding-sibling
        driver.findElement(By.xpath("//h1/preceding-sibling::*"));//1 element


    }
    @Test
    public void FindElementTableWithCssTest() {
        //print number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='tabletest4'] tr"));
        System.out.println("Numbers rows " + rows.size());
        for (WebElement el: rows) {
            System.out.println(el.getText());
        }
        // get row 4
        WebElement row4 = driver.findElement(By.cssSelector("table[class='tabletest4'] tr:nth-child(4)"));
        System.out.println("Text row 4 -> " + row4.getText());
        // xpath -> //table[@class='tabletest4']/tr[4]
        WebElement row4XPath = driver.findElement(By.xpath("//table[@class='tabletest4']//tr[4]"));
        System.out.println("Text row 4 (XPath) -> " + row4XPath.getText());
//
        // get row 2 and cell 2
        WebElement cell1 = driver.findElement(By.cssSelector("table[class='tabletest4'] tr:nth-child(2) td:nth-child(2)"));
        System.out.println("Text row 2 and cell 2 -> " + cell1.getText());
        //xpath -> //table[@class='tabletest4']//tr[2]/td[2]
        WebElement cell2XPath = driver.findElement(By.xpath("//table[@class='tabletest4']//tr[2]/td[2]"));
        System.out.println("Text row 2 and cell 2 (XPath) -> " + cell2XPath.getText());
//
        //last element in row
        WebElement LastCell = driver.findElement(By.cssSelector("table[class='tabletest4'] tr:nth-child(4) td:last-child"));
        System.out.println("LastCell -> " + LastCell.getText());
        //xpath -> //table[@class='tabletest4']//tr[4]/td[last()]
        WebElement LastCellXPath = driver.findElement(By.xpath("//table[@class='tabletest4']//tr[4]/td[last()]"));
        System.out.println("LastCell (XPath) -> " + LastCellXPath.getText());
    }
}
