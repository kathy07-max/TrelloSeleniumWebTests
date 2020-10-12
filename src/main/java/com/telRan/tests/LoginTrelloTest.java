package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.isAvatarPresent()) {
            app.logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        app.login("masuha02@mail.ru", "2871539@com");
        Assert.assertTrue(app.isAvatarPresent());

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        app.login("masuha02@mail.ru", "2871539@cov");
        Assert.assertTrue(app.isLogInErrorPresent());
        Assert.assertFalse(app.isAvatarPresent());

    }
}



