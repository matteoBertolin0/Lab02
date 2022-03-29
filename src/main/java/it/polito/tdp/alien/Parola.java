package it.polito.tdp.alien;

import java.util.*;

public class Parola {
	
	private String text;
	private List<String> listaTraduzioni;
	
	public Parola(String text) {
		this.text = text;
		listaTraduzioni = new ArrayList<String>();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getListaTraduzioni() {
		return listaTraduzioni;
	}

	public void setListaTraduzioni(String traduzione) {
		this.listaTraduzioni.add(traduzione);
	}

	@Override
	public String toString() {
		return text;
	}
	
	
	
}
