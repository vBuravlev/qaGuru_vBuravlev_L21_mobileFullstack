package mobile.tests.browserstack;

import io.appium.java_client.MobileBy;
import mobile.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


@Tag("browserStack")
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Наличие кнопки My lists на нижнем баре")
    void btnsOnBottomBarTest() {
        step("Есть кнопка My lists", () -> {
            $(MobileBy.AccessibilityId("My lists")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

}