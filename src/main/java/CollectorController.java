import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CollectorController implements WeatherObserver {
    public TextArea weatherDataOutput;
    public TextField idField;
    private boolean record;
    private WeatherDAO weatherDAO = new WeatherDAOSQLImpl();

    public void startDataCollection(ActionEvent actionEvent) {
        WeatherObservable weatherStation = new WeatherDataGenerator();
        new Thread(weatherStation).start();
        weatherStation.register(this);

    }

    public void startRecording(ActionEvent actionEvent) {
        this.record = !this.record;
    }

    @Override
    public void notify(WeatherDTO weatherDTO) {
        //Show data
        String text = weatherDataOutput.getText();
        text += "New Data! Time:" +weatherDTO.getTime() + ", Windspeed: " + weatherDTO.getWindSpeed() +"\r\n";
        weatherDataOutput.setText(text);
        //Save data
        if (this.record){
            weatherDTO.setWeatherStationId(idField.getText());
            weatherDAO.save(weatherDTO);
        }


    }

    public void loadData(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoadGUI.fxml"));
        try {
            FlowPane flowPane = fxmlLoader.load();
            Stage loadStage = new Stage();
            loadStage.setScene(new Scene(flowPane));
            loadStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
