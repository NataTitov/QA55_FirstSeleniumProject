package com.ait.qa55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
   WebDriver driver; // ob'yavivli peremennuyu do before method
    //before method-setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver.get("https://google.com");//without history
        driver.navigate().to("https://ilcarro.web.app");//with history
        driver.navigate().to("https://google.com");
        driver.navigate().back();
    }

    //test (chto testiruetsya, to tak i nasivaetsya)
    @Test
    public void openGooleTest(){
        System.out.println("Hello!");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //after method-tearDown
}
