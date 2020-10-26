package com.telRan.tests.fw;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardForm(Board board) {
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.getBoardName());
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        click(By.cssSelector("._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getBoardVisibility() + "']/../.."));
        if (isElementPresent(By.cssSelector(".X6LMWvod566P68"))) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));

    }

    public int getBoardsCount() {
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        return res;
    }

    public void confirmBoardCreation() {

        click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
    }
    public void deleteBoard() {
        click(By.cssSelector("a.quiet.js-delete"));
        click(By.cssSelector("input.js-confirm[type=submit]"));
    }

    public void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm[type=submit]"));
    }

    public void selectBoard(Board board) {
        click(By.cssSelector(".board-tile-details-name[title='" + board.getBoardName() + "']"));
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

    }

    public void changeNameBoard(Board board) {
        click(By.cssSelector(".js-rename-board"));
       wd.findElement(By.cssSelector(".js-board-name-input")).sendKeys((board.getBoardName()+ Keys.ENTER));


    }
}
