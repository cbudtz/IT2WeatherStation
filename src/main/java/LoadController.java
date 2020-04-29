import data.SQLConnector;
import data.WeatherDAO;
import data.WeatherDAOSQLImpl;
import data.WeatherDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class LoadController {
    public DatePicker datePicker;
    public TextArea weatherDataArea;

    public void LoadData(ActionEvent actionEvent) {
        LocalDateTime localDateTime = datePicker.getValue().atStartOfDay();
        Timestamp time = Timestamp.valueOf(localDateTime);
        WeatherDAO weatherDAO = new WeatherDAOSQLImpl();
        List<WeatherDTO> weatherData = weatherDAO.load(time);
        String text = "";
        for (WeatherDTO data: weatherData) {
            text += "ID: " + data.getId() + ", Time: " + data.getTime() + ", WindSpeed: " + data.getWindSpeed() + "\r\n";
        }
        weatherDataArea.setText(text);
    }
}
