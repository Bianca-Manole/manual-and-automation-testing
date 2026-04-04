import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTests {

    private TemperatureConverter temperatureConverter;

    @BeforeEach
    void setup() {
        temperatureConverter= new TemperatureConverter();
    }

    @Test
    void checkCelsiusToFahrenheitZero() {
        Assertions.assertEquals(32, temperatureConverter.celsiusToFahrenheit(0));
    }

    @Test
    void checkCelsiusToFahrenheit100() {
        Assertions.assertEquals(212, temperatureConverter.celsiusToFahrenheit(100));
    }

    @Test
    void checkCelsiusToFahrenheitMinut40() {
        Assertions.assertEquals(-40, temperatureConverter.celsiusToFahrenheit(-40));
    }

    @Test
    void checkFahrenheitToCelsius32() {
        Assertions.assertEquals(0, temperatureConverter.fahrenheitToCelsius(32));
    }

    @Test
    void checkFahrenheitToCelsius212() {
        Assertions.assertEquals(100, temperatureConverter.fahrenheitToCelsius(212));
    }

    @Test
    void checkReverseConversion() {
        Assertions.assertEquals(100, temperatureConverter.celsiusToFahrenheit(temperatureConverter.fahrenheitToCelsius(100)));
    }
}
