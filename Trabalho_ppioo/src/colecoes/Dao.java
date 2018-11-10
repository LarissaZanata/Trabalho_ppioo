package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Dao implements ColecoesDao{
	List<Album> listaDeAlbuns = new ArrayList<Album>();

	public void adicionaAlbum(Album album) {
		listaDeAlbuns.add(album);
	}
}
