package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SetConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class BrowserstackMobileDriver implements WebDriverProvider{

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", SetConfig.getAppiumVersion());
        mutableCapabilities.setCapability("browserstack.user", SetConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", SetConfig.getKey());
        mutableCapabilities.setCapability("app", SetConfig.getApp());
        mutableCapabilities.setCapability("device", SetConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", SetConfig.getPlatformVersion());
        mutableCapabilities.setCapability("project", SetConfig.getProjectName());
        mutableCapabilities.setCapability("build", SetConfig.getBuildName());
        mutableCapabilities.setCapability("name", SetConfig.getTestName());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl()  {

        try {
            return new URL(SetConfig.getUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
