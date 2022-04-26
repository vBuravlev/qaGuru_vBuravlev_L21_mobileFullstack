package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/emulation.properties"
})
public interface EmulationConfig extends Config {

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

    @Key("appiumUrl")
    String appiumUrl();

    @Key("appActivity")
    String appActivity();

    @Key("local")
    String local();

    @Key("language")
    String language();


}
