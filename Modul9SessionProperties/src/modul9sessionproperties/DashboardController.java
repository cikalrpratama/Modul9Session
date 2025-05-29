/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modul9sessionproperties;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author cikal r pratama
 */
public class DashboardController implements Initializable {

      //fx:id pada Dashboard.fxml didefinisikan menjadi variable disini
    @FXML private Label labelWelcome;
    @FXML private Button buttonLogout;

    @FXML
    private void handleButtonLogoutAction(ActionEvent event) throws Exception {
        // Hapus session
        Session.clearSession();

        // Kembali ke halaman login
        Main main = new Main();
        main.changeScene("Main.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Ambil data user dari session
        
        String username = (String) Session.getAttribute("Username");
        String password = (String) Session.getAttribute("Password");
        String fullname = (String) Session.getAttribute("Fullname");
        String role = (String) Session.getAttribute("Role");

        // Tampilkan data session pada labelWelcome
        labelWelcome.setText("Selamat datang, " + fullname + " (" + role + ")"
                + "\nSession Properties Class");
    }
}
    

