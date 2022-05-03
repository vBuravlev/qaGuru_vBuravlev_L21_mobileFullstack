package mobile.tests;

import com.codeborne.selenide.Configuration;
import config.SetConfig;
import mobile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import static mobile.helpers.Attach.getSessionId;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = null;
        SetConfig.setDeviceHost();
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        switch (System.getProperty("device")) {
            case "browserstack":
                Attach.addVideo(getSessionId());
                break;
            case "selenoid":
                // дописать реализацию
                break;
            default:
                break;
        }
    }
}