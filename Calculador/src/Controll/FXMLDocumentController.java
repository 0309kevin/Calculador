/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Historico.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kg598
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private PasswordField txtpass;
    @FXML
    private TextField txtlogin;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("cal");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT g FROM LoginGerente as g WHERE g.usuario = :usuario");
        
        query.setParameter("usuario", txtlogin.getText());
        
       
        if(!query.getResultList().isEmpty()){
             Login lg = (Login) query.getSingleResult();
            if(lg.getSenha().equals(txtpass.getText())){
                
                JOptionPane.showMessageDialog(null,"Bem Vindo");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Calculador/view/Calculadora.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),1250,700);
                
                Stage stage = new Stage();
                
                stage.setTitle("Calculadora");
                stage.setScene(scene);
                stage.show();
                
                
                
                
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Senha Incorreta!");
                alert.setTitle("Senha");
                alert.show();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Usuario INCORRETO");
            alert.setTitle("Usuario");
            alert.show();
        }
       
    }
    
}
