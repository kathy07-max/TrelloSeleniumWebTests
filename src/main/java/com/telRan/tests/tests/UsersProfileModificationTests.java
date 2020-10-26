package com.telRan.tests.tests;

import org.testng.annotations.Test;

public class UsersProfileModificationTests extends TestBase{

    @Test
    public void tetChangeAvatarForUser() throws InterruptedException {
        app.getHeader().clickOnAvatar();
        app.getHeader().openProfile();
        app.getProfile().switchToAtlassianWindow();
        app.getProfile().chengAvatar();

    }
}
