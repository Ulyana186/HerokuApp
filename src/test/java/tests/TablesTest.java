package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TablesPage;

public class TablesTest extends TestBase {

    @Test
    public void cellsContainExpectedValues() {
        TablesPage page = new TablesPage(driver, wait).open();
        Assert.assertEquals(page.cell(1, 1), "Smith");
        Assert.assertEquals(page.cell(1, 3), "jsmith@gmail.com");
        Assert.assertEquals(page.cell(2, 2), "Frank");
        Assert.assertEquals(page.cell(3, 4), "$100.00");
        Assert.assertEquals(page.cell(4, 3), "tconway@earthlink.net");
    }

    @Test
    public void sortingByLastNameChangesFirstRow() {
        TablesPage page = new TablesPage(driver, wait).open();
        Assert.assertNotEquals(page.cell(1, 1), "Bach", "До сортировки первой строкой не должен быть Bach");
        page.sortBy("Last Name");
        Assert.assertEquals(page.cell(1, 1), "Bach");
    }
}