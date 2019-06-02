package modelo;

public class Idiomas {
	
	private String codigo,datos;
	
	public Idiomas(String codigo, String datos) {
		this.codigo=codigo;
		this.datos=datos;
	}
	@Override
	public String toString() {
		return "Idioma [codigo=" + codigo + ", datos=" + datos + "]";
	}

}
