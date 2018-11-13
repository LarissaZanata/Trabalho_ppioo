package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Dao implements ColecoesDao{
	List<Album> listaDeAlbuns = new ArrayList<Album>();

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
	public void mostraAlbuns() {
		System.out.println("------Albuns------ ");
		for(int i = 0; i <listaDeAlbuns.size(); i++) {
			System.out.println(listaDeAlbuns.get(i).getNome());
		}
	}
	
	@Override
	public Album getAlBumPeloId(int id) {
		 for (Album album : listaDeAlbuns) {
		        if (album.getId() == id) 
		        	return album;
		    }
		    return null;
	}
}
