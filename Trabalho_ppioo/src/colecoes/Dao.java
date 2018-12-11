package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Dao implements ColecoesDao{
	List<Album> listaDeAlbuns = new ArrayList<Album>();
	List<Colecao> listaDeColecao = new ArrayList<Colecao>();

	
	/*Métodos para albuns*/
	
	@Override
	public void adicionaAlbum(Album album) {
		 		boolean albumExiste = false;
		
		for(int i =0; i < listaDeAlbuns.size(); i++) {
			if(this.listaDeAlbuns.get(i).getNome() == album.getNome()) {
				albumExiste = true;
			}
		}
		
		if(albumExiste) {//ver depois
			System.out.println("O album '" + album.getNome() + "' já existe.");
		}
		else {
			listaDeAlbuns.add(album);
		}
	}
	
	@Override
	public List<Album> retornaListaAlbuns() {		
		List<Album> lista = listaDeAlbuns;
		return lista;
	}
	
	public List<Colecao> retornaListaDeColecaoes(){
		List<Colecao> lista = listaDeColecao;
		return lista;
	}
	
	@Override
	public Album getAlBumPeloId(int id) {
		 for (Album album : listaDeAlbuns) {
		        if (album.getId() == id) 
		        	return album;
		    }
		    return null;
	}
	
	/*Métodos para colecoes*/
	
	@Override
	public boolean adicionarNovaColecao(String nomeColecao, int idAlbum) {
		Colecao colecao = new Colecao(idAlbum, nomeColecao);
		boolean colecaoExisteParaId = false;
		
		for (Colecao valor : listaDeColecao) {
			if ((valor.getNome().equals(nomeColecao)) && (valor.getIdAlbum() == idAlbum)) {
				colecaoExisteParaId = true;
				break;
			}
		}
	
		if(colecaoExisteParaId) {
			return colecaoExisteParaId;
		}
		else {
			listaDeColecao.add(colecao);
			return colecaoExisteParaId;
		}		
	}
	
	@Override
	public boolean adicionarFigurinhasColecao(int idAlbum, String nomeColecao, String figurinhas) {
		boolean figurinhasAdicionadas = false;
		for(int i = 0; i < listaDeColecao.size(); i++) {
			if(listaDeColecao.get(i).getIdAlbum() == idAlbum && listaDeColecao.get(i).getNome().equals(nomeColecao)) {
				String array[] = figurinhas.split(",");
				listaDeColecao.get(i).adicionarFigurinhaNaColecao(array);
				figurinhasAdicionadas = true;
			}
		}
		return figurinhasAdicionadas;
	}
	
	@Override
	public List<String> retornaFigurinhasColecao(int idAlbum, String nomeColecao) {
		List<String> novas = new ArrayList<String>();
		for(int i = 0; i < listaDeColecao.size(); i++) {
			if(listaDeColecao.get(i).getIdAlbum() == idAlbum && listaDeColecao.get(i).getNome().equals(nomeColecao)) {
					novas = listaDeColecao.get(i).GetfigNovas();
					break;
			}
		}	
		return novas;
	}
	
	@Override
	public List<String> retornaFigurinhasRepetidasColecao(int idAlbum, String nomeColecao) {
		List<String> repetidas = new ArrayList<String>();
		for(int i = 0; i < listaDeColecao.size(); i++) {
			if(listaDeColecao.get(i).getIdAlbum() == idAlbum && listaDeColecao.get(i).getNome().equals(nomeColecao)) {
					repetidas = listaDeColecao.get(i).GetfigRepetidas();
					break;
			}
		}	
		return repetidas;
	}
	
	
	
}
