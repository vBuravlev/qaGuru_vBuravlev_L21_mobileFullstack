package mobile.tests;

import com.codeborne.selenide.Configuration;
import config.SetConfig;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.LocalMobileDriver;
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

        switch (System.getProperty("device")) {
            case "emulation":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "selenoid":
                //реализовать позже
                break;
            default:
                throw new IllegalArgumentException("Ups, sorry, you chose an invalid option. You need to choose between real, emulator, browserstack, selenoid");
        }

    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        switch (System.getProperty("device")) {
            case "browserstack":
                Attach.addVideo(sessionId);
                break;
            case "selenoid":
                // дописать реализацию
                break;
            default:
                break;
        }
    }
}