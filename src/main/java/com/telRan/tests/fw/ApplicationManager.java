package com.telRan.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;


    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
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
