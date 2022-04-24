package mobile.drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.RealConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RealMobileDriver implements WebDriverProvider {
    public static RealConfig config = ConfigFactory.create(RealConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        File application = getApp();
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("platformName", config.platformName());
        mutableCapabilities.setCapability("deviceName", config.deviceName());
        mutableCapabilities.setCapability("app", application.getAbsolutePath());
        mutableCapabilities.setCapability("locale", config.local());
        mutableCapabilities.setCapability("language", config.language());
        mutableCapabilities.setCapability("appPackage", config.appPackage());
        mutableCapabilities.setCapability("appActivity", config.appActivity());

        return new AndroidDriver(getAppiumUrl(), capabilities);
    }

    private File getApp() {

        File application = new File(config.appPath());
        if (!application.exists()) {
            try (InputStream in = new URL(config.appUrl()).openStream()) {
                copyInputStreamToFile(in, application);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return application;
    }

    public static URL getAppiumUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
