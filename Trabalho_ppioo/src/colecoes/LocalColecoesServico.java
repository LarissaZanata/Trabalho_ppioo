package colecoes;

import java.util.List;

// Uma implementa��o de ColecoesServico que armazena os dados e executa as
// opera��es localmente. Todas as opera��es de armazenamento e recupera��o de
// dados s�o feitas atrav�s da inst�ncia dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;
	

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }
    
    /*M�todos para albuns*/
	
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
    
    /*M�todos para colecoes*/
    
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
