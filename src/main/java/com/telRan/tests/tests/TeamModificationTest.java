package com.telRan.tests.tests;

import com.telRan.tests.model.Team;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TeamModificationTest extends TestBase {

    @Test
    public void modifyTeamTest(){
        app.getTeam().selectFirstTeam();
        app.getTeam().clickOnSettingsButton();
        app.getTeam().renameTeam(new Team().setTeamName("12345"));
        app.getHeader().returnOnHomePage(By.cssSelector(".tabbed-pane-header-content"));
    }
}
