package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    int boardsBefore;
    int boardsAfter;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    public void stop() {
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

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    protected void returnOnHomePage(String locator) {
        new WebDriverWait(wd, 20).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmBoardCreation() {
       click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateNewBoard(){
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }

    public void fillBoardForm(String boardName, String teamVisible) {
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        click(By.cssSelector("._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + teamVisible + "']/../.."));
        if (isElementPresent(By.cssSelector(".X6LMWvod566P68"))) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));

    }

    protected void deleteBoard() {
        click(By.cssSelector("a.quiet.js-delete"));
        click(By.cssSelector("input.js-confirm[type=submit]"));
    }

    protected void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm[type=submit]"));
    }

    protected void selectMenuMore() {
        click(By.cssSelector(".board-menu-header-back-button"));
        click(By.cssSelector(".js-open-more"));
    }

    protected void enterInMenu() {
        if (isElementPresent(By.cssSelector(".board-menu-tab-content"))==false){
            click(By.cssSelector(".js-show-sidebar"));
        }

    }

    protected void selectBoard(String boardName) {
        click(By.cssSelector(".board-tile-details-name[title='" + boardName + "']"));
    }
}
