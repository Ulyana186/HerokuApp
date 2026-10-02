package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends TestBase {

    @Test
    public void arrowsChangeNumberFromEmptyField() {
        InputsPage page = new InputsPage(driver, wait).open();
        page.arrowUp();
        Assert.assertEquals(page.value(), "1");
        page.arrowDown();
        page.arrowDown();
        Assert.assertEquals(page.value(), "-1");
    }

    @Test
    public void arrowsChangeTypedNumbers() {
        InputsPage page = new InputsPage(driver, wait).open();
        page.type("5");
        page.arrowUp();
        Assert.assertEquals(page.value(), "6");
        page.type("-3");
        page.arrowUp();
        Assert.assertEquals(page.value(), "-2");
        page.type("0");
        page.arrowDown();
        Assert.assertEquals(page.value(), "-1");
    }

    @DataProvider(name = "nonNumeric")
    public Object[][] nonNumeric() {
        return new Object[][]{{"abc"}, {"!@#"}, {"e"}};
    }

    @Test(dataProvider = "nonNumeric")
    public void nonNumericInputIsRejected(String text) {
        InputsPage page = new InputsPage(driver, wait).open();
        page.type(text);
        Assert.assertEquals(page.value(), "", "Нецифровой ввод не должен попадать в поле");
        page.arrowUp();
        Assert.assertEquals(page.value(), "1");
    }
}