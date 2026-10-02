package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    @Test
    public void firstCheckboxCanBeChecked() {
        CheckboxesPage page = new CheckboxesPage(driver, wait).open();
        Assert.assertFalse(page.isChecked(0), "Первый чекбокс изначально unchecked");
        page.toggle(0);
        Assert.assertTrue(page.isChecked(0), "Первый чекбокс должен стать checked");
    }

    @Test
    public void secondCheckboxCanBeUnchecked() {
        CheckboxesPage page = new CheckboxesPage(driver, wait).open();
        Assert.assertTrue(page.isChecked(1), "Второй чекбокс изначально checked");
        page.toggle(1);
        Assert.assertFalse(page.isChecked(1), "Второй чекбокс должен стать unchecked");
    }
}