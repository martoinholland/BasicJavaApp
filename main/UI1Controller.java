package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UI1Controller {

    @FXML
    private AnchorPane formLogIn;
    @FXML
    private Label labelLogIn;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private TextField fieldEmail;
    @FXML
    private Button buttonLogIn;
    @FXML
    private Label labelWrong;

    @FXML
    private void authenticate(ActionEvent event) throws IOException {

        labelWrong.setVisible(false);
        Data data = new Data();
        ArrayList<Person> list = data.RetrieveAll();
        String user = fieldEmail.getText();
        String pass = fieldPassword.getText();
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            //check if username and password match
            if ((p.getUserName().equals(user)) && (p.getPassword().equals(pass))) {

                //open main menu
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                //pass user type to main menu
                MainMenuController controller = fxmlLoader.getController();
                controller.SetType(p.getType());
                stage.show();
                count++;

                //break out of loop when password and username match
                break;
            }
        }

        //check if the password and username have matched at all
        if (count == 0) {
            labelWrong.setVisible(true);
        }

        //clear text fields after authentication for security reasons
        fieldEmail.clear();
        fieldPassword.clear();
    }

}
