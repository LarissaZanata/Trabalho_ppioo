package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Dao implements ColecoesDao{
	List<Album> listaDeAlbuns = new ArrayList<Album>();

	public void adicionaAlbum(Album album) {
		boolean albumExiste = false;
		
		for(int i =0; i < listaDeAlbuns.size(); i++) {
			if(this.listaDeAlbuns.get(i).getNome() == album.getNome()) {
				albumExiste = true;
			}
		}
		
		if(albumExiste) {//ver depois
			System.out.println("O album '" + album.getNome() + "' j� existe.");
		}
		else {
			listaDeAlbuns.add(album);
		}	
	}
	
	public void mostraAlbuns() {
		System.out.println("------Albuns------ ");
		for(int i = 0; i <listaDeAlbuns.size(); i++) {
			System.out.println(listaDeAlbuns.get(i).getNome());
		}
	}
	
	public void mostrarPleoId(int id) {
		//boolean albumExiste = false;
		Album album = getAlBumPeloId(id);
		
		if(album != null) {
			System.out.println("----Informa��es do Album----");
			System.out.println("T�tulo: " + album.getNome());
			System.out.println("Quantidade de Figurinhas: " + album.getQuantidade());
		}
		else {
			System.out.println("Album com Id = " + id + " n�o existe.");
		}
		/*
		for(int i = 0; i <= listaDeAlbuns.size(); i++) {
			if(listaDeAlbuns.get(i).getId() == id) {
				albumExiste = true;
				System.out.println("----Informa��es do Album----");
				System.out.println("T�tulo: " + listaDeAlbuns.get(i).getNome());
				System.out.println("T�tulo: " + listaDeAlbuns.get(i).getQuantidade());
			}
		}
		
		if(!albumExiste) {
			System.out.println("Album com Id = " + id + " n�o existe.");
		}*/
	}
	
	public Album getAlBumPeloId(int id) {
		 for (Album album : listaDeAlbuns) {
		        if (album.getId() == id) 
		        	return album;
		    }
		    return null;
	}
}
