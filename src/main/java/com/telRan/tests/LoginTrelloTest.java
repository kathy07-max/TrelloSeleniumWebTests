package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTest {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        //create new instance of WebDriver (ex. open Chrom Browser)
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

    }

   @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //click on login button on welcome page
       wd.findElement(By.cssSelector("[href='/login']")).click();
       //fill login form
       //fill email
       wd.findElement(By.name("user")).click();
       wd.findElement(By.name("user")).clear();
       wd.findElement(By.name("user")).sendKeys("masuha02@mail.ru");
       //wait
       
       //click on login with atlassian button
       wd.findElement(By.id("login")).click();
       Thread.sleep(1000);
       //fill password
       wd.findElement(By.id("password")).click();
       wd.findElement(By.id("password")).clear();
       wd.findElement(By.id("password")).sendKeys("2871539@com");
       //confirm login
       wd.findElement(By.id("login-submit")).click();
    // er user logged in (is avatar present)

    }
   @AfterClass (enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
