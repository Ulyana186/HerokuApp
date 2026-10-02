package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage extends BasePage {
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public DropdownPage open() {
        openPath("/dropdown");
        return this;
    }

    private Select select() {
        return new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown)));
    }

    public List<String> optionTexts() {
        return select().getOptions().stream().map(WebElement::getText).toList();
    }

    public void selectByIndex(int index) {
        select().selectByIndex(index);
    }

    public String selectedText() {
        return select().getFirstSelectedOption().getText();
    }

    public boolean isOptionEnabled(int index) {
        return select().getOptions().get(index).isEnabled();
    }
}