package com.telRan.tests.tests;

import com.telRan.tests.model.Team;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @Test
    public void teamCreationFromHeader(){
        int before = app.getTeam().getTeamCount();
        app.getHeader().clickOnPlusButton();
        app.getHeader().selectCreateNewTeam();
        app.getTeam().fillCreationTeamForm(new Team().setTeamName("team qa-24_1").setType("small business"));
        app.getTeam().submitTeamCreationForm();
        app.getTeam().selectIwillDoThisLater();
        app.getHeader().returnOnHomePage(By.xpath("//*[@class='home-left-sidebar-container']//*[@class='icon-board icon-sm _2aV_KY1gTq1qWc']/../../.."));
        int after = app.getTeam().getTeamCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("before: " + before + "after" + after);

    }

}
