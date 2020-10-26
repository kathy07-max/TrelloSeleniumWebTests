package com.telRan.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    LeftNavigationMenuPage leftNav;
    ProfileHelper profile;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
         if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        leftNav = new LeftNavigationMenuPage(wd);
        profile = new ProfileHelper(wd);
    }

    public ProfileHelper getProfile() {
        return profile;
    }

    public LeftNavigationMenuPage getLeftNav() {
        return leftNav;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public void stop() {
        wd.quit();
    }
}
