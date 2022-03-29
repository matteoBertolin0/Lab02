package it.polito.tdp.alien;

import java.util.*;

public class Dizionario {
	
	private List<Parola> listaParole;
	
	public Dizionario() {
		this.listaParole = new ArrayList<Parola>();
	}
	
	public List<String> cercaTraduzioni(String parola){
		for(Parola p : listaParole) {
			if(p.getText().equalsIgnoreCase(parola)) {
				return p.getListaTraduzioni();
			}
		}
		return null;
	}
	
	public boolean add(String parola, String traduzione) {
		char[] cerca = parola.toCharArray();
		boolean ok=true;
		for(Character c : cerca) {
			if(!Character.isLetter(c)) {
				ok=false;
			}
			
		}
		char[] cerca1 = traduzione.toCharArray();
		for(Character c : cerca1) {
			if(!Character.isLetter(c)) {
				ok=false;
			}
			
		}
		
		if(ok) {
			List<Parola> temp = new ArrayList<Parola>(listaParole);
			if(listaParole.size()>=1) {
				for(Parola p : temp) {
					if(p.getText().equalsIgnoreCase(parola)) {
						p.setListaTraduzioni(traduzione);
						Parola p2 = new Parola(traduzione);
						p2.setListaTraduzioni(parola);
						listaParole.add(p2);
					}else if(p.getText().equalsIgnoreCase(traduzione)) {
						p.setListaTraduzioni(parola);
						Parola p1 = new Parola(parola);
						p1.setListaTraduzioni(traduzione);
						listaParole.add(p1);
					}else {
						Parola p1 = new Parola(parola);
						p1.setListaTraduzioni(traduzione);
						Parola p2 = new Parola(traduzione);
						p2.setListaTraduzioni(parola);
						listaParole.add(p1);
						listaParole.add(p2);
					}
				}			
			}else {
				Parola p1 = new Parola(parola);
				p1.setListaTraduzioni(traduzione);
				Parola p2 = new Parola(traduzione);
				p2.setListaTraduzioni(parola);
				listaParole.add(p1);
				listaParole.add(p2);
			}
		}
		
		return ok;
	}
}

