package model;

import java.time.LocalTime;

public class TextoMemento {

	protected String estadoTexto, hora;
	
	public TextoMemento(String texto){
		this.estadoTexto = texto;
		this.hora = 
				LocalTime.now().toString();
	}
	
	public String getTextoSalvo() {
		return this.estadoTexto;
	}
	
	public String getHora() {
		return this.hora;
	}
	
	public String toString() {
		return "Estado: " + this.estadoTexto + "\n hora: " + this.hora;
	}
}
