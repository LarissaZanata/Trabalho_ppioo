package colecoes;

import java.util.List;

// Esta interface deve conter métodos que armazenam e recuperam os dados
// inseridos no programa. Alguns possíveis métodos
// - salvaAlbum, armazena um álbum que pode ser recuperado posteriormente;
// - encontraAlbumPorId, recebe um id e devolve um álbum com este id (se
//   existir)
// - todosAlbuns, devolve uma lista com todos os álbuns
//
// Você deve criar uma implementação desta interface que armazena os dados em
// memória. Da mesma forma que a classe LocalColecoesServico tem uma classe de
// testes LocalColecoesServicoTest associada, a classe que você criar para
// implementar a interface ColecoesDao também deve ter uma classe de testes.
public interface ColecoesDao {
	
	public void adicionaAlbum(Album album);
	public List<Album> retornaListaAlbuns();
	public Album getAlBumPeloId(int id);
	public boolean adicionarNovaColecao( String nomeColecao, int idAlbum);
	public List<Colecao> retornaListaDeColecaoes();
	public void adicionarFigurinhasColecao(int idAlbum, String nomeColecao, String figurinhas);
}
