package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        //create new instance of WebDriver (ex. open Chrom Browser)
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

    }
    @AfterClass(enabled = true)
    public void tearDown(){
        wd.quit();
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();

    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
       click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    protected boolean isLogInErrorPresent() {
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email);
        click(By.id("login"));
        Thread.sleep(1000);
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }

    // er user logged in (is avatar present)
    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {

        return wd.findElements(locator).size()>0;
    }
}

