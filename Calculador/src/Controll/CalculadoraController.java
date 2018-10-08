/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kg598
 */
public class CalculadoraController implements Initializable {

    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private Button btnSoma;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button btnDivisão;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnMult;
    @FXML
    private Button btnLimpar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void soma(ActionEvent event) {
       double tx1 = Double.parseDouble(txt1.getText()); 
       double tx2 = Double.parseDouble(txt2.getText());
       double result;
       
       result = tx1 + tx2;
       
       String resultado = Double.toString(result);
       txtResultado.setText(resultado);
    }

    @FXML
    private void divisão(ActionEvent event) {
       double tx1 = Double.parseDouble(txt1.getText()); 
       double tx2 = Double.parseDouble(txt2.getText());
       double result;
       
       result = tx1 / tx2;
       
       String resultado = Double.toString(result);
       txtResultado.setText(resultado);
        
    }

    @FXML
    private void sub(ActionEvent event) {
        double tx1 = Double.parseDouble(txt1.getText()); 
       double tx2 = Double.parseDouble(txt2.getText());
       double result;
       
       result = tx1 - tx2;
       
       String resultado = Double.toString(result);
       txtResultado.setText(resultado);
    }

    @FXML
    private void mult(ActionEvent event) {
        double tx1 = Double.parseDouble(txt1.getText()); 
       double tx2 = Double.parseDouble(txt2.getText());
       double result;
       
       result = tx1 * tx2;
       
       String resultado = Double.toString(result);
       txtResultado.setText(resultado);
    }

    @FXML
    private void Limpar(ActionEvent event) {
        txt1.setText("");
        txt2.setText("");
        txtResultado.setText("");
    }
    
}
