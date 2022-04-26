package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/real.properties"
})
public interface RealConfig extends Config {

    @Key("url")
    String url();

    @Key("appPath")
    String appPath();

    @Key("appUrl")
    String appUrl();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("appiumUrl")
    String appiumUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("local")
    String local();

    @Key("language")
    String language();

}
