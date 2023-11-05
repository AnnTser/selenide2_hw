import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }



    @Test
    void exchangeFiguresByDragAndDropTest() {
        open("/drag_and_drop");
        $(withText("Drag and Drop")).shouldBe(visible);
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));

    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
