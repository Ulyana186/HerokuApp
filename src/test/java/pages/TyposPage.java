package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TyposPage extends BasePage {
    private final By paragraphs = By.tagName("p");

    public TyposPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public TyposPage open() {
        openPath("/typos");
        return this;
    }

    public String secondParagraph() {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(paragraphs, 1))
                .get(1).getText().trim().replace('\u2019', '\'');
    }

    public void reload() {
        driver.navigate().refresh();
    }
}