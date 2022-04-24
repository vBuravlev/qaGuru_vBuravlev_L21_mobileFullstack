package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/selenoid.properties"
})
public interface SelenoidConfig extends Config {

    @Key("url")
    String url();

    @Key("appPath")
    String appPath();

    @Key("appUrl")
    String appUrl();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("deviceName")
    String deviceName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("local")
    String local();

    @Key("language")
    String language();

    @Key("videoStorage")
    String videoStorage();

}
