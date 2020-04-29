package data;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDAO {
    void save(WeatherDTO weatherDTO);

    List<WeatherDTO> load(Timestamp time);
}
