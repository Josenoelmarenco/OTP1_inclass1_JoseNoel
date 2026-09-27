public class Main {

    // Entry point so the application actually "runs" — required for the Docker image demo.
    // It prints a few conversions so the container produces visible output.
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("=== Temperature Converter (In-class 4 - Jose Noel) ===");

        double fahrenheit = 98.6;
        System.out.printf("%.1f F = %.2f C%n", fahrenheit, converter.fahrenheitToCelsius(fahrenheit));

        double celsius = 37.0;
        System.out.printf("%.1f C = %.2f F%n", celsius, converter.celsiusToFahrenheit(celsius));

        double kelvin = 300.0;
        System.out.printf("%.1f K = %.2f C%n", kelvin, converter.kelvinToCelsius(kelvin));

        double check = 60.0;
        System.out.printf("Is %.1f C extreme? %b%n", check, converter.isExtremeTemperature(check));

        System.out.println("Application finished successfully.");
    }
}
