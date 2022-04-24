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

    @Key("appFileName")
    String appFileName();
    //

    @Key("appUrl")
    String appUrl();
    //"https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk?raw=true"

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("deviceName")
    String deviceName();

    @Key("appPackage")
    String appPackage();
    //"org.wikipedia.main.MainActivity"

    @Key("appActivity")
    String appActivity();
    //"org.wikipedia.alpha"

    @Key("local")
    String local();
    //"en"

    @Key("language")
    String language();
    //"en"


    @Key("videoStorage")
    String videoStorage();

}
