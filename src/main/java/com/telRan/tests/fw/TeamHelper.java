package com.telRan.tests.fw;

import com.telRan.tests.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }


    public void fillCreationTeamForm(Team team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));

        click(By.cssSelector("[data-test-id='header-create-team-type-input-" + team.getType() + "']"));

    }
    public void submitTeamCreationForm() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }
    public void selectIwillDoThisLater(){
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void selectFirstTeam() {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public void clickOnSettingsButton() {
        click(By.cssSelector("[data-test-id='home-team-settings-tab']"));
    }

    public void renameTeam(Team team) {
        click(By.cssSelector("._1dTnNTgBDWldkn[type='button']"));
        wd.findElement(By.xpath("//*[@id='displayName']")).clear();
        wd.findElement(By.xpath("//*[@id='displayName']")).sendKeys(team.getTeamName()+ Keys.ENTER);
    }

    public void deletionTeam() {
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm[type='submit']"));

    }
}
