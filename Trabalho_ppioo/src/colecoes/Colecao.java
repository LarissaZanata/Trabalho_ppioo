package colecoes;

public class Colecao {
	private String nome;
	private int[] figurinhas;
	private int[] figRepetidas;
	private int idAlbum;
	
	public Colecao(int idAlbum, String nomeColecao) {
		this.idAlbum = idAlbum;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getFigurinhas() {
		return figurinhas;
	}

	public void setFigurinhas(int[] figurinhas) {
		this.figurinhas = figurinhas;
	}

	public int[] getFigRepetidas() {
		return figRepetidas;
	}

	public void setFigRepetidas(int[] figRepetidas) {
		this.figRepetidas = figRepetidas;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	
	
}
