import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HoverTest {
    @BeforeAll()
    static void onSetUpConfigurations() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void hoverTest() {
        open("/");
        $(byTagAndText("button", "Solutions")).hover();
        $("#solutions-by-company-size-heading").sibling(0).$(byText("Enterprises")).click();
        sleep(5000);
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

}
