import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter conv = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0,   conv.fahrenheitToCelsius(32),   0.0001);
        assertEquals(100.0, conv.fahrenheitToCelsius(212), 0.0001);
        assertEquals(-40.0, conv.fahrenheitToCelsius(-40), 0.0001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0,  conv.celsiusToFahrenheit(0),   0.0001);
        assertEquals(212.0, conv.celsiusToFahrenheit(100), 0.0001);
        assertEquals(-40.0, conv.celsiusToFahrenheit(-40), 0.0001);
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(26.85,   conv.kelvinToCelsius(300),    0.0001); // enunciado: 300 K -> 26.85 C
        assertEquals(0.0,     conv.kelvinToCelsius(273.15), 0.0001); // congelacion del agua
        assertEquals(-273.15, conv.kelvinToCelsius(0),      0.0001); // cero absoluto -> -273.15 C
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(conv.isExtremeTemperature(51));    // calor extremo
        assertFalse(conv.isExtremeTemperature(50));   // limite justo, no extremo
        assertTrue(conv.isExtremeTemperature(-41));   // frio extremo
        assertFalse(conv.isExtremeTemperature(-40));  // limite justo por abajo, no extremo
    }
}
