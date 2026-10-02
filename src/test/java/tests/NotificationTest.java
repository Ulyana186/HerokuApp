package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationPage;

import java.util.List;

public class NotificationTest extends TestBase {
    private static final List<String> ALLOWED = List.of(
            "Action successful",
            "Action unsuccesful, please try again",
            "Action Unsuccessful, please try again");

    @Test
    public void notificationTextIsOneOfAllowedVariants() {
        String message = new NotificationPage(driver, wait).open().triggerAndGetMessage();
        Assert.assertFalse(message.isBlank(), "Нотификация пустая");
        Assert.assertTrue(ALLOWED.stream().anyMatch(message::startsWith),
                "Неожиданный текст нотификации: " + message);
    }
}