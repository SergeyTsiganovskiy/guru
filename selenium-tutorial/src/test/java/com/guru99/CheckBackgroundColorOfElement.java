package com.guru99;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CheckBackgroundColorOfElement {

  public static void main(String[] args) {
    String baseUrl = "http://newtours.demoaut.com/";
    System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();

    driver.get(baseUrl);
    WebElement link_Home = driver.findElement(By.linkText("Home"));
    WebElement td_Home = driver
            .findElement(By
                    .xpath("//html/body/div"
                            + "/table/tbody/tr/td"
                            + "/table/tbody/tr/td"
                            + "/table/tbody/tr/td"
                            + "/table/tbody/tr"));
    // Instantiate a new Actions object
    Actions builder = new Actions(driver);

    //Instantiate an Action using the Actions object
    //The build() method is always the final method used so that
    // all the listed actions will be compiled into a single step.
    Action mouseOverHome = builder.moveToElement(link_Home).build();

    String bgColor = td_Home.getCssValue("background-color");
    System.out.println("Before hover: " + bgColor);
    // Use the perform() method when executing the Action object we designed
    mouseOverHome.perform();
    bgColor = td_Home.getCssValue("background-color");
    System.out.println("After hover: " + bgColor);
    driver.close();
  }
}