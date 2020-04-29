package data;

import data.WeatherObserver;

public interface WeatherObservable extends Runnable {
    void register(WeatherObserver weatherObserver);
}
