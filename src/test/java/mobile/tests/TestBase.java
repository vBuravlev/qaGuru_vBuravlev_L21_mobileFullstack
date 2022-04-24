package mobile.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static mobile.drivers.DriverDeviceHost.getDeviceDriver;
import static mobile.helpers.Attach.getSessionId;

public class TestBase {

    private static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = getDeviceDriver(deviceHost);
        Configuration.browserSize = null;

//        switch (deviceHost) {
//            case "browserstack":
//                Configuration.browser = BrowserstackMobileDriver.class.getName();
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
//        Configuration.browserSize = null;
//        Configuration.timeout = 10000;
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
//       Attach.attachVideo(sessionId);

    }
}
