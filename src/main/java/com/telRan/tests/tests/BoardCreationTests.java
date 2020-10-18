package com.telRan.tests.tests;
import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @Test
    public void boardCreation(){
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateNewBoard();
        app.getBoard().fillBoardForm(new Board().setBoardName("qa board24").setTeam("public"));
        app.getBoard().confirmBoardCreation();
        app.getHeader().returnOnHomePage(By.cssSelector(".mod-list-add-button"));
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+ 1);
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
