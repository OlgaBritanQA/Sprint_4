package org.example.flow;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class MainTest {
    protected WebDriver driver;

    protected abstract WebDriver createDriver();

    protected abstract String getUrl();

    @Before
    public void setUp() {
        driver = createDriver();
        driver.get(getUrl());
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
