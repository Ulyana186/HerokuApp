package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final String BASE_URL = "https://the-internet.herokuapp.com";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void openPath(String path) {
        for (int attempt = 1; attempt <= 3; attempt++) {
            driver.get(BASE_URL + path);
            String title = driver.getTitle();
            if (title == null || !title.contains("Application Error")) {
                return;
            }
        }
        throw new IllegalStateException("Сайт недоступен (Application Error): " + BASE_URL + path);
    }
}