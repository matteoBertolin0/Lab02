package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtTraduzione;
    
    private Dizionario d;

    @FXML
    void handleClear(ActionEvent event) {

    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String search = txtParola.getText();
    	String[] parole = search.split(" ");
    	boolean ok;
    	
    	if(parole.length==1) {
    		String traduzioni = d.cercaTraduzioni(parole[0]).toString();
    		txtTraduzione.setText("Le traduzioni di "+search+" sono:\n"+traduzioni);
    	}else if(parole.length==2) {
    		ok=d.add(parole[0], parole[1]);
    		if(ok)
    			txtTraduzione.setText("Registrazione avvenuta correttamente!");
    		else
    			txtTraduzione.setText("Errore: le parole devono contenere solamente caratteri!");    			
    	}else {
    		txtTraduzione.setText("Formato errato!");
    	}

    }
    
    public void setModel(Dizionario model) {
    	this.d=model;
    }
    
    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
