package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablesPage extends BasePage {

    public TablesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public TablesPage open() {
        openPath("/tables");
        return this;
    }

    public String cell(int row, int col) {
        By locator = By.xpath("//table[@id='table1']//tbody//tr[" + row + "]//td[" + col + "]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void sortBy(String column) {
        By header = By.xpath("//table[@id='table1']//span[text()='" + column + "']");
        wait.until(ExpectedConditions.elementToBeClickable(header)).click();
    }
}