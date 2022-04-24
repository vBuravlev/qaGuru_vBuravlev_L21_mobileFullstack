package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/emulation.properties"
})
public interface EmulationConfig extends Config {

    @Key("url")
    String url();

    @Key("appFileName")
    String appFileName();


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


}
