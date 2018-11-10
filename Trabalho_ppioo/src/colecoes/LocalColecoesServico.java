package colecoes;

// Uma implementa��o de ColecoesServico que armazena os dados e executa as
// opera��es localmente. Todas as opera��es de armazenamento e recupera��o de
// dados s�o feitas atrav�s da inst�ncia dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;
	

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }
	
	public int adicionaAlbum(String nome, int numFigs) {
		Album album = new Album(nome, numFigs);
		dao.adicionaAlbum(album);
		return album.getId();
	}
	
/*	
	public Album getAlbumPeloId(int id) {
		return dao.getAlBumPeloId(id)
	}
	
	public testAdicionaAlbum() {
		servico = ...;
		int id = servico.adicionaAlbum("a", 2);
		Album album = servico.getAlBumPeloId(id);
	}
	*/
}
