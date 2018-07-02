import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Dominik on 31.07.17.
 */
public class TableViewProducts {

    Scene listScene;
    TableView<Product> table;
    TextField nameInput, priceInput, priceInvestput, sellPriceput;

    public static void display() {
        
        Stage window = new Stage();
        window.setTitle("Products List");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(100);

        //Products List

        //Name Column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Phone Type");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price Column
        TableColumn<Product, String> priceColumn = new TableColumn<>("Wholesale Price");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //FinalIncome Column
        TableColumn<Product, String> amountColumn = new TableColumn<>("Final Income");
        amountColumn.setMinWidth(150);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        //PriceInvest Column
        TableColumn<Product, String> priceInvestColumn = new TableColumn<>("Repaircosts");
        priceInvestColumn.setMinWidth(150);
        priceInvestColumn.setCellValueFactory(new PropertyValueFactory<>("priceInvest"));

        //SellPrice Column
        TableColumn<Product, String> sellPriceColumn = new TableColumn<>("Retail Price");
        sellPriceColumn.setMinWidth(150);
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));

        TableViewProducts product = new TableViewProducts();

        //Name
        product.nameInput = new TextField();
        product.nameInput.setPromptText("Phone Type");
        product.nameInput.setMinWidth(100);

        //Price
        product.priceInput = new TextField();
        product.priceInput.setPromptText("Wholesale Price");

        //PriceInvest
        product.priceInvestput = new TextField();
        product.priceInvestput.setPromptText("Repaircosts");

        //sellPrice
        product.sellPriceput = new TextField();
        product.sellPriceput.setPromptText("Retail Price");


        //Button
        Button addButton = new Button("Add");
        addButton.getStyleClass().add("button-add");
        addButton.setOnAction(event -> {
            product.addButtonClicked();
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> product.deleteButtonClicked());
        deleteButton.getStyleClass().add("button-delete");
        Button backMenu = new Button("Back");
        backMenu.setOnAction(event -> window.close());

        Button saveButton = new Button("Save");

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(product.nameInput, product.priceInput, product.priceInvestput, product.sellPriceput, addButton, deleteButton, backMenu);

        product.table = new TableView<>();
        product.table.getColumns().addAll(nameColumn, priceColumn, priceInvestColumn, sellPriceColumn, amountColumn);

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(product.table, hBox);

        product.listScene = new Scene(layout1, 1000, 600);
        product.listScene.getStylesheets().add("listDesign.css");
        window.setScene(product.listScene);
        window.showAndWait();
    }

    //ViewMenu Methods

    //products List


    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setPriceInvest(Double.parseDouble(priceInvestput.getText()));
        product.setSellPrice(Double.parseDouble(sellPriceput.getText()));
        product.getAmount();
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        priceInvestput.clear();
        sellPriceput.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Product> productsSelected, allProducts;
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems();

        productsSelected.forEach(allProducts::remove);
    }



}
