package mobile.drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidConfig;
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


public class SelenoidMobileDriver implements WebDriverProvider {
    public static SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        File application = getApp();
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("platformName", config.platformName());
        mutableCapabilities.setCapability("deviceName", config.deviceName());
        mutableCapabilities.setCapability("version", config.platformVersion());
        mutableCapabilities.setCapability("appPackage", config.appPackage());
        mutableCapabilities.setCapability("locale", config.local());
        mutableCapabilities.setCapability("language", config.language());
        mutableCapabilities.setCapability("appActivity", config.appActivity());
        mutableCapabilities.setCapability("app", application.getAbsolutePath());
        mutableCapabilities.setCapability("enableVNC", true);
        mutableCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver(getSelenoidUrl(), capabilities);
    }


    private File getApp() {
        String appPath = "src/test/resources/apk/"+config.appFileName();

        File application = new File(appPath);
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

    public static URL getSelenoidUrl() {
        try {
            return new URL(config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
