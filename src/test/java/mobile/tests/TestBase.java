package mobile.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.EmulationMobileDriver;
import mobile.drivers.RealMobileDriver;
import mobile.drivers.SelenoidMobileDriver;
import mobile.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static mobile.helpers.Attach.getSessionId;

public class TestBase {

    static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        if (deviceHost == null) {
            System.setProperty("deviceHost", "emulation");
            deviceHost = System.getProperty("deviceHost");
        }

        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "selenoid":
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = EmulationMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = RealMobileDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("Error in deviceHost=" + deviceHost +
                        ". You must run with parameter -DdeviceHost=browserstack or selenoid or emulator or real");
        }
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();

//        switch (deviceHost) {
//            case "browserstack":
//                Attach.attachVideo(sessionId);
//                break;
//            case "selenoid":
//                Configuration.browser = SelenoidMobileDriver.class.getName();
//                break;
//            case "emulation":
//                Configuration.browser = EmulationMobileDriver.class.getName();
//                break;
//            case "real":
//                Configuration.browser = RealMobileDriver.class.getName();
//                break;
//            default:
//                throw new IllegalArgumentException("Error in deviceHost=" + deviceHost +
//                        ". You must run with parameter -DdeviceHost=browserstack or selenoid or emulator or real");
//        }

//        if(deviceHost.equals("browserstack")) {
//            Attach.attachVideo(sessionId);
//        }
    }
}
