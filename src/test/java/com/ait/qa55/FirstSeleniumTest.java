package com.ait.qa55; //com. - eto prinyato

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
   WebDriver driver; // ob'yavivli peremennuyu do before method

    //before method-setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximalnoe okno - na ves' ekran
        //driver.get("https://google.com");//without history
        driver.navigate().to("https://ilcarro.web.app");//with history
        // zhdem chtobi vse elementi progrusilis' (wait for all elements on the site to load before starting test)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        driver.navigate().refresh();// obnovlenie stranici/peresagruska
    }

    //test (chto testiruetsya, to tak i nasivaetsya)
    @Test
    public void openGooleTest(){
        System.out.println("Hello!");
    }

    //after method-tearDown
    @AfterMethod(enabled = false)//posmotrt' to li otkrito, pri nabled = false srasu ne sakrivaetsya
    public void tearDown(){
        //driver.quit(); // all tabs and browser
        driver.close(); // sakrivaet tol'ko tekushuyu vkladku (only one tab)
    }


}
