package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTest extends TestBase {

    @Test
    public void allOptionsArePresent() {
        DropdownPage page = new DropdownPage(driver, wait).open();
        Assert.assertEquals(page.optionTexts(),
                List.of("Please select an option", "Option 1", "Option 2"));
    }

    @Test
    public void canSelectFirstAndSecondOption() {
        DropdownPage page = new DropdownPage(driver, wait).open();
        page.selectByIndex(1);
        Assert.assertEquals(page.selectedText(), "Option 1");
        page.selectByIndex(2);
        Assert.assertEquals(page.selectedText(), "Option 2");
    }

    @Test
    public void placeholderOptionIsDisabled() {
        DropdownPage page = new DropdownPage(driver, wait).open();
        Assert.assertFalse(page.isOptionEnabled(0), "Пункт-заглушка не должен быть доступен");
    }
}