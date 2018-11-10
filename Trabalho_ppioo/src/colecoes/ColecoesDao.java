package colecoes;

// Esta interface deve conter m�todos que armazenam e recuperam os dados
// inseridos no programa. Alguns poss�veis m�todos
// - salvaAlbum, armazena um �lbum que pode ser recuperado posteriormente;
// - encontraAlbumPorId, recebe um id e devolve um �lbum com este id (se
//   existir)
// - todosAlbuns, devolve uma lista com todos os �lbuns
//
// Voc� deve criar uma implementa��o desta interface que armazena os dados em
// mem�ria. Da mesma forma que a classe LocalColecoesServico tem uma classe de
// testes LocalColecoesServicoTest associada, a classe que voc� criar para
// implementar a interface ColecoesDao tamb�m deve ter uma classe de testes.
public interface ColecoesDao {
	
	public void adicionaAlbum(Album album);
}
