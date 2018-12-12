package colecoes;

import java.util.List;

// Cada método desta interface é responsável por uma funcionalidade do programa.
// Os métodos declarados nesta interface devem ser implementados na classe
// LocalColecoesServico.
public interface ColecoesServico {
	public int adicionaAlbum(String nome, int numFigs);
	public List<Album> retornaListaAlbuns();
	public Album getAlBumPeloId(int id);
	public Album mostrarAlbumPeloId(int id);
	public boolean adicionarNovaColecao(int idlbum, String nome);
	public List<Colecao> retornaListaDeColecao();
	public boolean adicionarFigurinhas(int idAlbum, String nomeColecao, String figurinhas);
	public int[] retornaFigurinhasDaColecao(int idAlbum, String nomeCol);
	public int[] retornaFigurinhasDaColecaoFaltantes(int idAlbum, String nomeCol);
	public int calculaPorcentagemFigurinhasAtual(int idAlbum, String nomeColecao);
	public int calculaPorcentagemFigurinhasFaltantes(int idAlbum, String nomeColecao);
}
