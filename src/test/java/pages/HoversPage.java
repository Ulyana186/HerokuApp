package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HoversPage open() {
        openPath("/hovers");
        return this;
    }

    private By figure(int n) {
        return By.xpath("(//div[@class='figure'])[" + n + "]");
    }

    public void hoverOverProfile(int n) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(figure(n)));
        new Actions(driver).moveToElement(element).perform();
    }

    public String profileName(int n) {
        By name = By.xpath("(//div[@class='figure'])[" + n + "]//h5");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(name)).getText();
    }

    public void clickProfileLink(int n) {
        By link = By.xpath("(//div[@class='figure'])[" + n + "]//a");
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }
}