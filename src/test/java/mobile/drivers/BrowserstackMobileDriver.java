package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import mobile.helpers.BrowserStack;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class BrowserstackMobileDriver extends BrowserStack implements WebDriverProvider {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", config.userName());
        mutableCapabilities.setCapability("browserstack.key", config.accessKey());
        mutableCapabilities.setCapability("app", config.appUrl());
        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version", config.os_version());
        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.buildName());
        mutableCapabilities.setCapability("name", config.testName()+"_"+ LocalDateTime.now());
        mutableCapabilities.setCapability("browserstack.appium_version", config.appium_version());

        return new AndroidDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}

