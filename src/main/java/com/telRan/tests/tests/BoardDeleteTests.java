package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeleteTests extends TestBase{

    @Test
    public void deletionBoard(){
        int before = app.getBoard().getBoardsCount();
        app.getBoard().selectBoard(new Board().setBoardName("qa_24_4"));
        app.getHeader().enterInMenu();
        app.getHeader().selectMenuMore();
        app.getBoard().closeBoard();
        app.getBoard().deleteBoard();
        app.getHeader().returnOnHomePage(By.cssSelector(".big-message.quiet"));
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before - 1);
    }


}
