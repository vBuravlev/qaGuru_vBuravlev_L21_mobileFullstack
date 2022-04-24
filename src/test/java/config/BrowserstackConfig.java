package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("userName")
    String userName();

    @Key("accessKey")
    String accessKey();

    @Key("url")
    String url();

    @Key("appUrl")
    String appUrl();

    @Key("videoUrl")
    String videoUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("appium_version")
    String appium_version();

    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("testName")
    String testName();
}
