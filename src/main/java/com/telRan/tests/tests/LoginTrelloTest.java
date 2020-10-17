package com.telRan.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getHeader().isAvatarPresent()) {
            app.getHeader().logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        app.getSession().login("masuha02@mail.ru", "2871539@com");
        Assert.assertTrue(app.getHeader().isAvatarPresent());

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        app.getSession().login("masuha02@mail.ru", "2871539@cov");
        Assert.assertTrue(app.getSession().isLogInErrorPresent());
        Assert.assertFalse(app.getHeader().isAvatarPresent());

    }
}



