package mobile.drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulationMobileDriver implements WebDriverProvider {
    public static EmulationConfig config = ConfigFactory.create(EmulationConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File application = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.platformName());
        options.setDeviceName(config.deviceName());
        options.setPlatformVersion(config.platformVersion());
        options.setApp(application.getAbsolutePath());
        options.setLocale(config.local());
        options.setLanguage(config.language());
        options.setAppPackage(config.appPackage());
        options.setAppActivity(config.appActivity());

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
            return new URL(config.appiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
