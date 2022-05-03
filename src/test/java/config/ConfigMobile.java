package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/${device}.properties"})

public interface ConfigMobile extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("url")
    String url();

    @Key("app")
    String app();

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appiumVersion") //BrowserStack
    String appiumVersion();

    @Key("projectName") //BrowserStack
    String projectName();

    @Key("buildName") //BrowserStack
    String buildName();

    @Key("testName") //BrowserStack
    String testName();

    @Key("appFileName") //Local
    String appFileName();

    @Key("appPackage") //Local
    String appPackage();

    @Key("appActivity") //Local
    String appActivity();

    @Key("locale") //Local
    String locale();

    @Key("language") //Local
    String language();
}