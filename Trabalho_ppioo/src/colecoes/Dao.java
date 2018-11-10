package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Dao implements ColecoesDao{
	List<Album> listaDeAlbuns = new ArrayList<Album>();

	public void adicionaAlbum(Album album) {
		listaDeAlbuns.add(album);
	}
	
	public void mostraAlbuns() {
		for(int i = 0; i <listaDeAlbuns.size(); i++) {
			System.out.println(listaDeAlbuns.get(i).getNome());
		}
	}
	
	public Album getAlBumPeloId(int id) {
		 for (Album album : listaDeAlbuns) {
		        if (album.getId() == id) 
		        	return album;
		    }
		    return null;
	}
}
