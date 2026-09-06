import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter conv = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0,   conv.fahrenheitToCelsius(32),  0.0001);
        assertEquals(100.0, conv.fahrenheitToCelsius(212), 0.0001);
        assertEquals(-40.0, conv.fahrenheitToCelsius(-40), 0.0001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, conv.celsiusToFahrenheit(0), 0.0001);
        // TODO: agrega 100 -> 212.0  y  -40 -> -40.0  (copia la línea de arriba y cambia los números)
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(conv.isExtremeTemperature(51));   // 51 sí es extremo
        assertFalse(conv.isExtremeTemperature(50));  // 50 no lo es
        // TODO: agrega  assertTrue(...-41)  y  assertFalse(...-40)
    }
}