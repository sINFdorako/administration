import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Dominik on 31.07.17.
 */
public class ConfirmBox {


    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(50);

        Label label = new Label(message);
        label.getStyleClass().add("label-enterpriseCustom");

        Button button1 = new Button("Yes");
        button1.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button button2 = new Button("No");
        button2.setOnAction(e -> {
            answer = false;
            window.close();
        });

        BorderPane layout = new BorderPane();

        VBox vbox = new VBox(20);
        vbox.getChildren().add(label);
        vbox.setAlignment(Pos.CENTER);
        layout.setTop(vbox);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(button1, button2);
        hbox.setAlignment(Pos.CENTER);
        layout.setCenter(hbox);

        Scene scene = new Scene(layout, 300, 100);
        scene.getStylesheets().add("Design.css");
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }
}
