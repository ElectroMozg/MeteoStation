import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

public class Weather {

    private static final String API_KEY = "084ade3fa402115354dbb2e85e7a9a3c";
    private final OWM weatherAPI;
    private final String city;
    private double temperature;
    private double humidity;
    private double pressure;


    public Weather(String city) {
        this.city = city;
        weatherAPI = new OWM(API_KEY);
        // getting current weather data for city
        refreshMeasures();
    }

    public void refreshMeasures() {
        try {
            CurrentWeather  currentWeather = weatherAPI.currentWeatherByCityName(this.city);

            temperature = currentWeather.getMainData().getTemp();
            humidity = currentWeather.getMainData().getHumidity();
            pressure = currentWeather.getMainData().getPressure();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        double tempK = temperature;
        double scale = Math.pow(10, 1);
        double tempC = Math.ceil((tempK - 273.15)*scale)/scale;
        return tempC;
    }

    public double getHumidity() {
        double scale = Math.pow(10, 1);
        return Math.ceil(humidity *scale)/scale;
    }

    public double getPressure() {
        double pressurePa = pressure;
        double scale = Math.pow(10, 1);
        return Math.ceil(pressurePa*0.750062*scale)/scale;
    }
}
