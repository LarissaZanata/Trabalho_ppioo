package colecoes;

import java.util.List;

// Cada m�todo desta interface � respons�vel por uma funcionalidade do programa.
// Os m�todos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {
	public int adicionaAlbum(String nome, int numFigs);
	public List<Album> retornaListaAlbuns();
	public Album getAlBumPeloId(int id);
	public Album mostrarAlbumPeloId(int id);
	public boolean adicionarNovaColecao(int idlbum, String nome);
}
