package org.example;

import api.WebDriverConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandlingScript {

    public static void main(String[] args) {
        WebDriverConfig.setUp();
        Selenide.open("http://the-internet.herokuapp.com/windows");

        WebDriver driver = WebDriverRunner.getWebDriver();
        String originalWindow = driver.getWindowHandle();

        Selenide.$("a[href='/windows/new']").click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.close();

        driver.switchTo().window(originalWindow);

        Selenide.closeWebDriver();
    }
}
