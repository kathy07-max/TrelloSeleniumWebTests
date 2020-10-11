package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (isAvatarPresent()) {
            logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        login("masuha02@mail.ru", "2871539@com");
        Assert.assertTrue(isAvatarPresent());

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        login("masuha02@mail.ru", "2871539@cov");
        Assert.assertTrue(isLogInErrorPresent());
        Assert.assertFalse(isAvatarPresent());

    }
}



