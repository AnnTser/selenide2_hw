import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckByHoverTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selectEnterprizeByHoverTest() {

        open("/");
        $(".header-menu-wrapper").$(byTagAndText("button", "Solutions")).hover();
        $(".header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();
        $(withText("To build, scale, and deliver secure software.")).shouldBe(visible);

    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
