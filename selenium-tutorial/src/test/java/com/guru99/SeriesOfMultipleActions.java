package com.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeriesOfMultipleActions {
  public static void main(String[] args) {
    System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
    String baseUrl = "http://facebook.com/";
    WebDriver driver = new FirefoxDriver();
    driver.get(baseUrl);

    WebElement txtUserName = driver.findElement(By.id("email"));

    Actions builder = new Actions(driver);

    Action seriesOfActions = builder
            .moveToElement(txtUserName)
            .click()
            .keyDown(txtUserName, Keys.SHIFT)
            .sendKeys(txtUserName, "hello")
            .keyUp(txtUserName,Keys.SHIFT)
            .doubleClick(txtUserName)
            .contextClick()
            .build();

    seriesOfActions.perform();
  }
}

