package com.telRan.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.init();
        app.login("masuha02@mail.ru", "2871539@com");

    }

    @AfterClass(enabled = false)
    public void tearDown() {
        app.stop();
    }


}

