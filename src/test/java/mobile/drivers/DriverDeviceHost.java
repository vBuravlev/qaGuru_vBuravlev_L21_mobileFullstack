package mobile.drivers;

public class DriverDeviceHost {
    public static String getDeviceDriver(String deviceHost) {

        switch (deviceHost) {
            case "browserstack":
                return BrowserstackMobileDriver.class.getName();
            case "selenide":
                return SelenoidMobileDriver.class.getName();
            case "emulation":
                return EmulationMobileDriver.class.getName();
            case "real":
                return RealMobileDriver.class.getName();

            default:
                throw new RuntimeException("Select device: browserstack / emulation / real / selenide");
        }
    }
}