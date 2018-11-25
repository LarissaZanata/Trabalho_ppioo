package colecoes;

import java.util.List;

// Uma implementação de ColecoesServico que armazena os dados e executa as
// operações localmente. Todas as operações de armazenamento e recuperação de
// dados são feitas através da instância dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;
	

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }
    
    /*Métodos para albuns*/
	
    @Override
	public int adicionaAlbum(String nome, int numFigs) {
		Album album = new Album(nome, numFigs);
		dao.adicionaAlbum(album);
		return album.getId();
	}
	
    @Override
	public List<Album> retornaListaAlbuns() {
		List<Album> lista = dao.retornaListaAlbuns();
		return lista;
	}
	
    @Override
	public Album getAlBumPeloId(int id) {
		return dao.getAlBumPeloId(id);
	}
	
    @Override
	public Album mostrarAlbumPeloId(int id) {
    	Album album = dao.getAlBumPeloId(id);
    	return album;
	}
    
    /*Métodos para colecoes*/
    
    @Override
    public List<Colecao> retornaListaDeColecao(){
    	List<Colecao> lista = dao.retornaListaDeColecaoes();
    	return lista;
    }
    
    @Override
    public boolean adicionarNovaColecao(int idAlbum, String nome) {
	   //Colecao colecao = new Colecao(idAlbum, nome);
	   boolean colecaoJaExiste = false;
	   return colecaoJaExiste = dao.adicionarNovaColecao(nome, idAlbum);
   }
    
    @Override
    public void adicionarFigurinhas(int idAlbum, String nomeColecao, String figurinhas) {
    	dao.adicionarFigurinhasColecao(idAlbum, nomeColecao, figurinhas);
    }

}
