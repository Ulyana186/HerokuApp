package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoversTest extends TestBase {

    @Test
    public void hoverShowsProfileNames() {
        HoversPage page = new HoversPage(driver, wait).open();
        for (int n = 1; n <= 3; n++) {
            page.hoverOverProfile(n);
            Assert.assertEquals(page.profileName(n), "name: user" + n);
        }
    }

    @Test
    public void profileLinksOpenWithoutError() {
        HoversPage page = new HoversPage(driver, wait);
        for (int n = 1; n <= 3; n++) {
            page.open();
            page.hoverOverProfile(n);
            Assert.assertEquals(page.profileName(n), "name: user" + n);
            page.clickProfileLink(n);
            Assert.assertTrue(driver.getCurrentUrl().endsWith("/users/" + n),
                    "Неожиданный URL: " + driver.getCurrentUrl());
            Assert.assertFalse(driver.getPageSource().contains("Not Found"),
                    "Профиль user" + n + " открылся с ошибкой 404");
        }
    }
}