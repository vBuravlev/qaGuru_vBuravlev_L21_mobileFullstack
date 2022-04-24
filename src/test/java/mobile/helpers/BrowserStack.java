package mobile.helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static String videoUrlBrowserStack(String sessionId) {
        return given()
                .auth().basic(config.userName(), config.accessKey())
                .when()
                .get(config.videoUrl() + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }

}
