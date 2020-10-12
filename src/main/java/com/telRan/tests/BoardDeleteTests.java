package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeleteTests extends TestBase{

    @Test
    public void deletionBoard(){
        app.boardsBefore = app.getBoardsCount();
        app.selectBoard("new qa board1");
        app.enterInMenu();
        app.selectMenuMore();
        app.closeBoard();
        app.deleteBoard();
        app.returnOnHomePage(".big-message.quiet");
        app.boardsAfter = app.getBoardsCount();
        System.out.println("was: " + app.boardsBefore + " now: " + app.boardsAfter);
        Assert.assertEquals(app.boardsAfter, app.boardsBefore - 1);
    }


}
