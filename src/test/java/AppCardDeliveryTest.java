import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AppCardDeliveryTest {

    @BeforeEach
    void setUpTests() {
        open("http://localhost:9999");
    }

    @Test
    void testFormV1() {
        $("[data-test-id=city] input").setValue("Самара");
        $("[data-test-id=date] input").setValue("08 05 2023");
        $("[data-test-id=name] input").setValue("Гусарский Гусь");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
    }

    @Test
    void testFormV2() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").setValue("08 05 2023");
        $("[data-test-id=name] input").setValue("Гусарский-Павловский Гусь Хрустальный");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
    }

    @Test
    void testFormV3() {
        $("[data-test-id=city] input").setValue("Саратов");
        $("[data-test-id=date] input").setValue("08 05 2023");
        $("[data-test-id=name] input").setValue("Гусарский Гусёнок");
        $("[data-test-id=phone] input").setValue("+79023004000");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
    }
}
