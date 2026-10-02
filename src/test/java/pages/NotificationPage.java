package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage extends BasePage {
    private final By trigger = By.linkText("Click here");
    private final By flash = By.id("flash");

    public NotificationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NotificationPage open() {
        openPath("/notification_message");
        return this;
    }

    public String triggerAndGetMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(trigger)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flash)).getText();
    }
}