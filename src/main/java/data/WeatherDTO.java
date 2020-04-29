package data;

import java.sql.Timestamp;

public class WeatherDTO {
    private int id;
    private String weatherStationId;
    private double windSpeed;
    private double windDirection;
    private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeatherStationId() {
        return weatherStationId;
    }

    public void setWeatherStationId(String weatherStationId) {
        this.weatherStationId = weatherStationId;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
