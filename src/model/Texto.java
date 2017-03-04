package model;

public class Texto {

	protected String texto, hora;
	TextoCareTaker careTaker;
	TextoMemento estadoSalvoAnterior;
	
	public Texto() {
		careTaker = new TextoCareTaker();
		texto = new String();
		hora = new String();
	}
	
	public void escreverTexto(String novoTexto) {
		careTaker.adicionarMemento(new TextoMemento(novoTexto));
		texto = novoTexto;
	}
	
	public void escritaAnterior() {
		estadoSalvoAnterior = careTaker.getEstadoSalvoAnterior();
		texto = estadoSalvoAnterior.getTextoSalvo();
		hora = estadoSalvoAnterior.getHora();
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void mostrarTexto() {
		System.out.println(texto);
	}
	
	private static Texto instancia;
	
	public static Texto getInstancia() {
		if (instancia == null)
			instancia = new Texto();
		return instancia;
	}
}
