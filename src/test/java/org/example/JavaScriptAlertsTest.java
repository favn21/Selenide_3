package org.example;
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
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;

        Selenide.open("http://the-internet.herokuapp.com/javascript_alerts");

        $(By.xpath("//button[text()='Click for JS Alert']")).click();

        WebDriver driver = WebDriverRunner.getWebDriver();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        alert.accept();

        $(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();
        alertText = alert.getText();

        alert.dismiss();

        $(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();
        alertText = alert.getText();

        alert.sendKeys("Hello World");
        alert.accept();

        String resultText = $(By.id("result")).getText();

        Selenide.closeWebDriver();
    }
}
