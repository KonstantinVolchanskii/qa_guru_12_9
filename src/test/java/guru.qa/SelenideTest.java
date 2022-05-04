package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("open page-find text Test")
    @Test
    void checkForTextTest() {

        Selenide.open("https://github.com/");
        $("[data-test-selector=nav-search-input]")
                .setValue("selenide")
                .pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h2").shouldHave(text("selenide / selenide"));
        $("ul.UnderlineNav-body").$("#wiki-tab").click();
        $(".filter-bar").$("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(exactText("SoftAssertions"));
        $(".filterable-active").click();
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:"))
                .scrollTo()
                .$(".anchor").hover();

    }
        @DisplayName("Drag and Drop Test")
        @Test
        void checkDragAndDropWithSelenideMethod() {
            open("https://the-internet.herokuapp.com/drag_and_drop");
            $("#column-a").shouldHave(text("A"));
            $("#column-b").shouldHave(text("B"));
            $("#column-a").dragAndDropTo($("#column-b"));
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        }
}

