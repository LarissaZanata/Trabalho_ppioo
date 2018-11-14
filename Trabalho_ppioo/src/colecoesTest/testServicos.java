package colecoesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import colecoes.Album;
import colecoes.ColecoesServico;
import colecoes.Dao;
import colecoes.LocalColecoesServico;

public class testServicos {
	
	@Test
	public void testAdicionaAlbum() {
		Dao dao = new Dao();
        ColecoesServico servico = new LocalColecoesServico(dao);
		servico.adicionaAlbum("album-teste", 50);
		Album album = servico.getAlBumPeloId(1);
		assertEquals("album-teste", album.getNome());
		assertEquals(50, album.getQuantidade());
		assertEquals(1, album.getId());
	}
	
	@Test
	public void testRetornaListaAlbuns() {
		Dao dao = new Dao();
		ColecoesServico servico = new LocalColecoesServico(dao);
		servico.adicionaAlbum("album-teste", 2);
		servico.adicionaAlbum("album-teste-2", 10);
		List<Album> lista = servico.retornaListaAlbuns();
		assertEquals(2, lista.size());
	}
	
	@Test
	public void testRetornaListaAlbunsVazia() {
		Dao dao = new Dao();
		ColecoesServico servico = new LocalColecoesServico(dao);
		List<Album> lista = servico.retornaListaAlbuns();
		assertEquals(0, lista.size());
	}
}
