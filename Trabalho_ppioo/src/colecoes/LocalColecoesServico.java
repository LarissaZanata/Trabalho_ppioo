package colecoes;

import java.util.ArrayList;
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
    public boolean adicionarFigurinhas(int idAlbum, String nomeColecao, String figurinhas) {
    	boolean figurinhasAdiciondas = false;
    	figurinhasAdiciondas =  dao.adicionarFigurinhasColecao(idAlbum, nomeColecao, figurinhas);
    	return figurinhasAdiciondas;
    }
 
    @Override
    public int calculaPorcentagemFigurinhasAtual(int idAlbum, String nomeColecao){
    	int quantidade = 0;
    	int tamanhoAtualColecao = 0;
    	int porcentagem;
    	Album album = dao.getAlBumPeloId(idAlbum);
    	int figurinhas[] = new int[album.getQuantidade()];
    	
    	figurinhas = retornaFigurinhasDaColecao(idAlbum, nomeColecao);
    	
    	
    	for(int i = 0; i < figurinhas.length; i++) {
    		if(figurinhas[i] != -1) {
    			quantidade++;
    		}
    	}
    	
    	porcentagem = ( quantidade * album.getQuantidade())/100;
    	
    	return porcentagem;
    }
    
    @Override
    public int calculaPorcentagemFigurinhasFaltantes(int idAlbum, String nomeColecao) {
    	int quantidade = 0;
    	int tamanhoAtualColecao = 0;
    	int porcentagem;
    	Album album = dao.getAlBumPeloId(idAlbum);
    	int figurinhas[] = new int[album.getQuantidade()];
    	
    	figurinhas = retornaFigurinhasDaColecaoFaltantes(idAlbum, nomeColecao);
    	
    	for(int i = 0; i < figurinhas.length; i++) {
    		if(figurinhas[i] != -1) {
    			quantidade++;
    		}
    	}
    	porcentagem = ( quantidade * album.getQuantidade())/100;
    	
    	return porcentagem;
    }

    
    @Override
    public int[] retornaFigurinhasDaColecao(int idAlbum, String nomeCol){
    	Album album = dao.getAlBumPeloId(idAlbum);
    	List<String> figsRetorno = new ArrayList<String>();
    	int figurinhasNaColecao[] = new int[album.getQuantidade()];
		int figFaltantes[] = new int [album.getQuantidade()];
    	figsRetorno = dao.retornaFigurinhasColecao(idAlbum, nomeCol);
    	for(int i = 0; i < figurinhasNaColecao.length; i++ ) {
    		figurinhasNaColecao[i] = -1;
    		 figFaltantes[i] = -1;
    	}
    	
    	for(int i = 1; i < figurinhasNaColecao.length + 1; i++) {
    		for(int j = 0; j < figsRetorno.size(); j++) {
    			if(Integer.parseInt(figsRetorno.get(j)) == i) {
    				figurinhasNaColecao[i] = Integer.parseInt(figsRetorno.get(j));
    			}
    		}
    		
    	}
    	return figurinhasNaColecao;
    }
    
    @Override
    public int[] retornaFigurinhasDaColecaoFaltantes(int idAlbum, String nomeCol){
    	Album album = dao.getAlBumPeloId(idAlbum);
    	List<String> figsRetorno = new ArrayList<String>();
    	int figurinhasNaColecao[] = new int[album.getQuantidade()];;
		int figFaltantes[] = new int [album.getQuantidade()];
    	figsRetorno = dao.retornaFigurinhasColecao(idAlbum, nomeCol);
    	for(int i = 0; i < figurinhasNaColecao.length; i++ ) {
    		figurinhasNaColecao[i] = -1;
    		 figFaltantes[i] = -1;
    	}
    	
    	for(int i = 0; i < figurinhasNaColecao.length; i++) {
    		for(int j = 0; j < figsRetorno.size(); j++) {
    			if(Integer.parseInt(figsRetorno.get(j)) == i) {
    				figurinhasNaColecao[i] = Integer.parseInt(figsRetorno.get(j));
    			}
    			else {
    				figFaltantes[i] = i;
    			}
    		}
    		
    	}
    	return figFaltantes;
    }

}
