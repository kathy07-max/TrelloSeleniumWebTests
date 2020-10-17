package com.telRan.tests.tests;


import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {

    @Test
    public void teamDelete(){
        app.getTeam().selectFirstTeam();
        app.getTeam().clickOnSettingsButton();
        app.getTeam().deletionTeam();

    }
}
