package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());

    }

    @FXML
    Button addButton;
    @FXML
    Button deleteButton;
    @FXML
    Button editButton;
    @FXML
    Button clearButton;
    @FXML
    TextField descriptionTextField;
    @FXML
    DatePicker datePicker;
    @FXML
    ListView<LocalItem> itemList;

    ObservableList<LocalItem> list = FXCollections.observableArrayList();



    @FXML
    public void addItem(Event i){
        // adds item to list with two fields
        list.add(new LocalItem(datePicker.getValue() ,descriptionTextField.getText()));
        itemList.setItems(list);
        refresh();
    }


    @FXML
    private void editItem(Event i)  {
        // finding the item selected
        final int selectedIdx = itemList.getSelectionModel().getSelectedIndex();
        if ( selectedIdx != -1 ) {
            String itemToRemove = String.valueOf(itemList.getSelectionModel().getSelectedItem());

            final int newSelectedIdx =
                    (selectedIdx == itemList.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            itemList.getItems().remove(selectedIdx);
            itemList.getSelectionModel().select(newSelectedIdx);
            //deletes item selected
            list.remove(selectedIdx);

        }
        //adds new item
        list.add(new LocalItem(datePicker.getValue() ,descriptionTextField.getText()));
        itemList.setItems(list);
        refresh();



    }
    @FXML
    public void deleteItem(Event i) {
        //finding the item slected
        final int selectedIdx = itemList.getSelectionModel().getSelectedIndex();
        if ( selectedIdx != -1 ) {
            String itemToRemove = String.valueOf(itemList.getSelectionModel().getSelectedItem());

            final int newSelectedIdx =
                    (selectedIdx == itemList.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            itemList.getItems().remove(selectedIdx);
            itemList.getSelectionModel().select(newSelectedIdx);
            //deletes ite in list
            list.remove(selectedIdx);

        }
        refresh();
    }

        @FXML
        private void clearItems (Event i){
        //clears all items in list
            list.clear();
        }


        private void refresh () {
            // clears both fields for new input
            datePicker.setValue(LocalDate.now());
            descriptionTextField.setText(null);

        }

        public Object[] getItems () {
            return itemList.getItems().toArray();
        }


    }