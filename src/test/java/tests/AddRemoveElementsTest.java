package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {

    @Test
    public void addTwoElementsAndDeleteOne() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait).open();
        page.clickAdd();
        page.clickAdd();
        Assert.assertEquals(page.deleteCount(), 2, "После добавления должно быть 2 элемента");
        page.clickDeleteFirst();
        Assert.assertEquals(page.deleteCount(), 1, "После удаления должен остаться 1 элемент");
    }

    @Test
    public void noDeleteButtonsOnOpen() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait).open();
        Assert.assertEquals(page.deleteCount(), 0, "Сразу после открытия кнопок Delete быть не должно");
    }
}