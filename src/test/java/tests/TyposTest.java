package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TyposPage;

public class TyposTest extends TestBase {
    private static final String CORRECT = "Sometimes you'll see a typo, other times you won't.";
    private static final String WITH_TYPO = "Sometimes you'll see a typo, other times you won,t.";

    @Test
    public void paragraphIsOneOfKnownVariants() {
        String text = new TyposPage(driver, wait).open().secondParagraph();
        Assert.assertTrue(text.equals(CORRECT) || text.equals(WITH_TYPO),
                "Неожиданный текст: " + text);
    }

    @Test
    public void correctTextAppearsAfterReloads() {
        TyposPage page = new TyposPage(driver, wait).open();
        boolean found = false;
        for (int i = 0; i < 10 && !found; i++) {
            found = CORRECT.equals(page.secondParagraph());
            if (!found) {
                page.reload();
            }
        }
        Assert.assertTrue(found, "Корректный текст не появился за 10 загрузок");
    }
}