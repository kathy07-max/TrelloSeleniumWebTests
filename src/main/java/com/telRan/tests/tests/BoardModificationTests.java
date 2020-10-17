package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{

    @Test
    public void modifyBoardTest(){
        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().changeNameBoard(new Board().setBoardName("qa_24_4"));
        app.getHeader().returnOnHomePage(By.cssSelector(".mod-list-add-button"));
    }
}
