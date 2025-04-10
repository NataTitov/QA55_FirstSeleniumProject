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

public class TableTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void FindElementTableWithCssTest() {
        //print number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("table tr"));
        System.out.println("Numbers rows " + rows.size());
        for (WebElement el: rows) {
            System.out.println(el.getText());
        }
        // get row 4
        WebElement row4 = driver.findElement(By.cssSelector("tr:nth-child(4)"));// xpath ->//tr[4]
        System.out.println("Text row 4 -> " + row4.getText());

        // get row 7 and cell 1 -> first item in row
        WebElement cell1 = driver.findElement(By.cssSelector("tr:nth-child(7) td:nth-child(1)"));
        //xpath ->//tr[7]/td[1]
        System.out.println("Text cell 1 -> " + cell1.getText());

        //last element in row
        WebElement LastCell = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        //xpath ->//tr[8]/td[last()]
        System.out.println("LastCell -> " + LastCell.getText());
    }
}
