package com.telRan.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @Test
    public void boardCreation(){
        app.boardsBefore = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateNewBoard();
        app.fillBoardForm("new qa board1", "public");
        app.confirmBoardCreation();
        app.returnOnHomePage(".mod-list-add-button");
        app.boardsAfter = app.getBoardsCount();
        System.out.println("was: " + app.boardsBefore + " now: " + app.boardsAfter);
        Assert.assertEquals(app.boardsAfter, app.boardsBefore + 1);
    }
}

//
//    @Test
//    public void boardCreationTest(){
//       boardCreation("test4 QA board");
//      }
//
//    public void boardCreation(String boardName){
//        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
//        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
//        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
//       click(By.xpath("//button[@data-test-id='create-board-submit-button']"));
//       // click(By.cssSelector("[data-test-id='create-board-submit-button']"));
//       click(By.cssSelector("[data-test-id='header-home-button']"));
//
//    }
//
//}
