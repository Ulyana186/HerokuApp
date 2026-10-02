package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElementsPage extends BasePage {
    private final By addButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AddRemoveElementsPage open() {
        openPath("/add_remove_elements/");
        wait.until(d -> "complete".equals(
                ((JavascriptExecutor) d).executeScript("return document.readyState")));
        return this;
    }

    public void clickAdd() {
        int before = deleteCount();
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtons, before + 1));
    }

    public void clickDeleteFirst() {
        int before = deleteCount();
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtons)).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtons, before - 1));
    }

    public int deleteCount() {
        return driver.findElements(deleteButtons).size();
    }
}