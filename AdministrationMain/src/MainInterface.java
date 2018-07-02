/**
 * Created by Dominik on 30.07.17.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInterface extends Application {
    Stage window, productWindow;
    Scene scene;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        productWindow = new Stage();
        productWindow.setTitle("Product List");
        window.setTitle("Easy Enterprise Administration");
        Label welcomeLabel = new Label("Welcome to Enterprise Administration");
        welcomeLabel.getStyleClass().add("label-enterpriseCustom");

        //Closing properly
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgramm();
        });

        productWindow.setOnCloseRequest(e -> {
            e.consume();
            closeProgramm();
        });


        //view Menu
        Menu viewMenu = new Menu("Main");
        viewMenu.getItems().add(new MenuItem("statistics"));
        MenuItem products = new MenuItem(("edit new list"));
        products.setOnAction(event -> openProductList());
        viewMenu.getItems().add(products);

        //Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(viewMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(welcomeLabel);
        layout.getChildren().addAll();

        scene = new Scene(layout, 1000,800);
        scene.getStylesheets().add("Design.css");
        window.setScene(scene);
        window.show();
    }



    //ConfirmBox closing window properly

    public void closeProgramm(){
        Boolean answer = ConfirmBox.display("Attention", "Are you sure you want to exit?");
        if(answer){
            window.close();
        }
    }

    //Product List
    public void openProductList(){
        TableViewProducts.display();
    }


}
