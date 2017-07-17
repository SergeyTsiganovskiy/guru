package com.guru99;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginTest() {
        wd.get("http://www.demo.guru99.com/V4/");
        wd.findElement(By.name("uid")).click();
        wd.findElement(By.name("uid")).clear();
        wd.findElement(By.name("uid")).sendKeys("mngr88256");
        wd.findElement(By.name("uid")).click();
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("ysyvYsA");
        wd.findElement(By.name("password")).sendKeys(Keys.ENTER);
        wd.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).click();

        Assert.assertTrue(wd.findElement(By.xpath("//td[@style=\"color: green\"]")).getText().contains("mngr88256"));

    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
