package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTtile;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label lbTotalPrice;

    @FXML
    private Button btnPlaceOrder;

    public CartScreenController (Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML 
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } 
                }
            });
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue <? extends String> observable, String oldValue, String newValue) {
                showFiterMedia(newValue);
            }
        });

        cart.getItemsOrdered().addListener((ListChangeListener.Change<? extends Media> change) -> {
            updateTotalPrice();
        });
        updateTotalPrice();
    }
    
    private void updateTotalPrice() {
        float total = cart.totalPrice();
        javafx.application.Platform.runLater(() -> {
            lbTotalPrice.setText(String.format("%.2f $", total));
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) btnPlay.setVisible(true);
        else btnPlay.setVisible(false);
    }

    void showFiterMedia(String s) {
        cart.searchByTitleNmt(s);
    }

     @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Order Error");
            errorAlert.setContentText("Your cart is empty. Please add items to your cart before placing an order.");
            errorAlert.showAndWait();
            return;
        }
    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Details");
        alert.setHeaderText("Your Order Details");
        
        StringBuilder details = new StringBuilder();
        details.append("***********************CART***********************\n");
        details.append("Ordered Items:\n");
        for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
            Media media = cart.getItemsOrdered().get(i);
            details.append(String.format("%d. Media %s - %s: %.2f$\n",
                    i + 1, media.getTitle(), media.getCategory(), media.getCost()));
        }
        details.append(String.format("Total cost: %.2f $\n", cart.totalPrice()));
        details.append("***************************************************");
    
        alert.setContentText(details.toString());
    
        alert.showAndWait();
    
        cart.emptyCart();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Media Information");
        alert.setHeaderText("Now Playing");
        alert.setContentText(String.format("You are playing: %s\nLength: %d minutes", media.getTitle(), media.getLength()));

        alert.showAndWait();
    }

}