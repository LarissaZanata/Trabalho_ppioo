package colecoes;

// Uma implementação de ColecoesServico que armazena os dados e executa as
// operações localmente. Todas as operações de armazenamento e recuperação de
// dados são feitas através da instância dao.
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
