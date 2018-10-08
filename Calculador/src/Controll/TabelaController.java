/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author mauricio
 */
public class TabelaController implements Initializable {

    @FXML
    private TableView<?> Tbtabela;
    @FXML
    private TableColumn<?, ?> Codigo;
    @FXML
    private TableColumn<?, ?> tbprim;
    @FXML
    private TableColumn<?, ?> tbsegun;
    @FXML
    private TableColumn<?, ?> tbopera;
    @FXML
    private TableColumn<?, ?> tbresult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listar();
    }    
    
    private void listar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("focus");
        EntityManager em = emf.createEntityManager();
                
        // import javax.persistence.Query;
        Query query = em.createQuery("SELECT a FROM Historico as a");
        // import java.util.List;
        // import br.edu.ifro.model.Aluno;
        List<Historico.Historico> cliente = query.getResultList();
        // import javafx.collections.ObservableList;
        // import javafx.collections.FXCollections;
        ObservableList oCliente = FXCollections.observableArrayList(cliente); 
        Tbtabela.setItems(oCliente);
    }
}
