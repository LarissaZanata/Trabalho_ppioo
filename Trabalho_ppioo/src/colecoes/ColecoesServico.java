package colecoes;

// Cada método desta interface é responsável por uma funcionalidade do programa.
// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {
	public int adicionaAlbum(String nome, int numFigs);
	public void mostrarAlbuns();
	public Album getAlBumPeloId(int id);
	public void mostrarAlbumPeloId(int id);
}
