package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public boolean isLogInErrorPresent() {
        return isElementPresent(By.cssSelector("#login-error"));
    }

    public void login(String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email);
        click(By.id("login"));
        Thread.sleep(1000);
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
    }
}
