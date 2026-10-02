package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputsPage extends BasePage {
    private final By input = By.tagName("input");

    public InputsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public InputsPage open() {
        openPath("/inputs");
        return this;
    }

    private WebElement field() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(input));
    }

    public void type(String text) {
        WebElement f = field();
        f.clear();
        f.sendKeys(text);
    }

    public void arrowUp() {
        field().sendKeys(Keys.ARROW_UP);
    }

    public void arrowDown() {
        field().sendKeys(Keys.ARROW_DOWN);
    }

    public String value() {
        return field().getAttribute("value");
    }
}