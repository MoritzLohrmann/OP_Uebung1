package gui;

import javafx.stage.Stage;

//import java.io.IOException;

import business.*;

public class SportvereinControl {
	
	private SportvereinModel sportvereinmodel;
	private SportvereinView sportvereinview;
	

	public SportvereinControl(Stage primaryStage) {
		super();
		this.sportvereinmodel = new SportvereinModel();
		this.sportvereinview = new SportvereinView(this,  primaryStage);
	}
	void nehmeSportvereinAuf(){
    	try{ 
    		sportvereinmodel.nehmeSportvereinAuf(
    				sportvereinview.txtName.getText(), 
    				sportvereinview.txtOrt.getText(),
    				Integer.parseInt(sportvereinview.txtAnzahlMitglieder.getText()),
    				Integer.parseInt(sportvereinview.txtAnzahlEhemaligerMitglieder.getText()),
    				sportvereinview.txtSportarten.getText().split(";"));
    		sportvereinview.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		sportvereinview.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    void zeigeSportvereineAn(){
    	if(sportvereinmodel.getVerein() != null){
    		sportvereinview.txtAnzeige.setText(sportvereinmodel.sportverein.gibSportvereinZurueck(' '));
    	}
    	else{
    		sportvereinview.zeigeInformationsfensterAn("Bisher wurde keine Sportverein aufgenommen!");
    	}
    }    
		  
    void leseAusDatei(String typ) {
    	try {
      		if("csv".equals(typ)){
      			sportvereinmodel.leseAusDatei();
      			sportvereinview.zeigeInformationsfensterAn("Der Sportverein wurde gelesen!");
      		}
       		else{
       			sportvereinview.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(Exception exc){
			sportvereinview.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	void schreibeSportvereineInCsvDatei() {
		try {
			sportvereinmodel.schreibeSportvereineInCsvDatei();
			sportvereinview.zeigeInformationsfensterAn(
	   			"Die Sportvereine wurden gespeichert!");
		}	
		catch(Exception exc){
			sportvereinview.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}


}
