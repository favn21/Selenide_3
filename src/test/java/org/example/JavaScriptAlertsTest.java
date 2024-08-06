package org.example;
import api.WebDriverConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class JavaScriptAlertsTest {

    @Test
    public void testJavaScriptAlerts() {
        WebDriverConfig.setUp();

        Selenide.open("http://the-internet.herokuapp.com/javascript_alerts");

        $(By.xpath("//button[text()='Click for JS Alert']")).click();

        WebDriver driver = WebDriverRunner.getWebDriver();
        Alert alert = driver.switchTo().alert();

        alert.accept();

        $(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();

        alert.dismiss();

        $(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();


        alert.sendKeys("Hello World");
        alert.accept();

        Selenide.closeWebDriver();
    }
}
