package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage extends BasePage {
    private final By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CheckboxesPage open() {
        openPath("/checkboxes");
        return this;
    }

    private WebElement box(int index) {
        return wait.until(ExpectedConditions.numberOfElementsToBe(checkboxes, 2)).get(index);
    }

    public boolean isChecked(int index) {
        return box(index).isSelected();
    }

    public void toggle(int index) {
        box(index).click();
    }
}