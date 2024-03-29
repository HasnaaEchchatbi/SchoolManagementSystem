package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private Button cancelbutton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView SMSImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File SMSFile =new File("imgjava/graduation-high-school-university-concept-space-text.jpg");
        Image SMSImage =new Image(SMSFile.toURI().toString());
        SMSImageView.setImage(SMSImage);

        File lockFile =new File("imgjava/lock_5797972.png");
        Image lockImage =new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }
    private void loginbuttonOnAction(ActionEvent event){

        if (usernameTextField.getText().isBlank()== false && enterPasswordField.getText().isBlank()== false){
          validateLogin();
        }else{
            loginMessageLabel.setText("Please enter your username and password");
        }
    }
    private void cancelbuttonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
      dblogincon connectNow =new dblogincon();
        Connection connectDB = connectNow.getConnection();
        String verifylogin ="SELECT count(1) FROM user_account WHERE username='" +usernameTextField.getText()+
                "'AND password='" +enterPasswordField.getText()+"'";
    try{
        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifylogin);
        while (queryResult.next()){
            if (queryResult.getInt(1)==1){
                loginMessageLabel.setText("Congratulations");

            }else{
                loginMessageLabel.setText("Invalid login .Please try again");

            }
        }
    }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }

    }


}
