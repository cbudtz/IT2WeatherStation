package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAOSQLImpl implements WeatherDAO {
    @Override
    public void save(WeatherDTO weatherDTO) {
        Connection conn = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO weatherData(weatherStationId, windSpeed, windDirection, time) VALUES (?,?,?,?)");
            preparedStatement.setString(1,weatherDTO.getWeatherStationId());
            preparedStatement.setDouble(2,weatherDTO.getWindSpeed());
            preparedStatement.setDouble(3,weatherDTO.getWindDirection());
            preparedStatement.setTimestamp(4,weatherDTO.getTime());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WeatherDTO> load(Timestamp time) {
        List<WeatherDTO> data = new ArrayList<>();
        Connection connection = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM weatherData WHERE time > ? ");
            preparedStatement.setTimestamp(1,time);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                WeatherDTO weatherDTO = new WeatherDTO();
                weatherDTO.setId(resultSet.getInt("id"));
                weatherDTO.setWeatherStationId(resultSet.getString("weatherStationId"));
                weatherDTO.setWindSpeed(resultSet.getDouble("windSpeed"));
                weatherDTO.setWindDirection(resultSet.getDouble("windDirection"));
                weatherDTO.setTime(resultSet.getTimestamp("time"));
                data.add(weatherDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
