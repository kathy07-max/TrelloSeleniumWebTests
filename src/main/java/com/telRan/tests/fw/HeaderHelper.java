package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateNewBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }
    public void selectCreateNewTeam() {
        click(By.xpath("//button[@data-test-id='header-create-team-button']"));
    }

    public void returnOnHomePage(By locator) {
        waitForElement(locator, 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    // er user logged in (is avatar present)
    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }
    public void logout() {
        clickOnAvatar();
        clickLogOut();

    }
    public void selectMenuMore() {
        if(isElementPresent(By.cssSelector(".board-menu-header-back-button"))){
            click(By.cssSelector(".board-menu-header-back-button"));
        }
        click(By.cssSelector(".js-open-more"));
    }

    public void enterInMenu() {
        if (isElementPresent(By.cssSelector(".board-menu-tab-content"))==false){
            click(By.cssSelector(".js-show-sidebar"));
        }

    }
}
