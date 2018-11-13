package colecoes;

// Uma implementa��o de ColecoesServico que armazena os dados e executa as
// opera��es localmente. Todas as opera��es de armazenamento e recupera��o de
// dados s�o feitas atrav�s da inst�ncia dao.
public class LocalColecoesServico implements ColecoesServico {

    private final ColecoesDao dao;
	

    public LocalColecoesServico(ColecoesDao dao) {
        this.dao = dao;
    }
	
    @Override
	public int adicionaAlbum(String nome, int numFigs) {
		Album album = new Album(nome, numFigs);
		dao.adicionaAlbum(album);
		return album.getId();
	}
	
    @Override
	public void mostrarAlbuns() {
		dao.mostraAlbuns();
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

}
