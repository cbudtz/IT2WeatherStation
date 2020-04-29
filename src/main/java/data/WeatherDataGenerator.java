package data;

import java.sql.Timestamp;

public class WeatherDataGenerator implements WeatherObservable {
    private WeatherObserver weatherObserver;

    @Override
    public void register(WeatherObserver weatherObserver) {
        this.weatherObserver = weatherObserver;
    }

    @Override
    public void run() {
        while (true){
            WeatherDTO weatherDTO = new WeatherDTO();
            weatherDTO.setTime(new Timestamp(System.currentTimeMillis()));
            weatherDTO.setWindDirection(Math.random()*360);
            weatherDTO.setWindSpeed(Math.random()*30);
            if (weatherObserver != null) {
                weatherObserver.notify(weatherDTO);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
