package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import mobile.helpers.BrowserStack;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;


public class BrowserstackMobileDriver extends BrowserStack implements WebDriverProvider {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities caps) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(caps);

            // Set your access credentials
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", config.userName());
        mutableCapabilities.setCapability("browserstack.key", config.accessKey());
        mutableCapabilities.setCapability("app", config.appUrl());

            // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version", config.os_version());

            // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.buildName());
        mutableCapabilities.setCapability("name", config.testName()+" "+ LocalDateTime.now());

            return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);

    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.appUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}

