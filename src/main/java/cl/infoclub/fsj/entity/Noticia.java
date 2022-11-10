package cl.infoclub.fsj.entity;

public class Noticia {
	
	private String titulo,noticia,imagen;
	
	public Noticia(String titulo, String noticia, String imagen) {
		super();
		this.titulo = titulo;
		this.noticia = noticia;
		this.imagen = imagen;
	}
	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNoticia() {
		return noticia;
	}
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", noticia=" + noticia + ", imagen=" + imagen + "]";
	}

	
	
}
