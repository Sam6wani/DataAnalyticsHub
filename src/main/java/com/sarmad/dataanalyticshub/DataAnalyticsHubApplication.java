package com.sarmad.dataanalyticshub;

import com.sarmad.dataanalyticshub.dao.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class DataAnalyticsHubApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DataAnalyticsHubApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Data Analytics Hub");
        DataAnalyticsHubController controller = fxmlLoader.getController();
        controller.loadLoginForm(scene);

        if (Database.isOk()) {
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("ERROR DATABASE NOT OK");
        }
    }





    public static void main(String[] args) {
        launch();
    }
}