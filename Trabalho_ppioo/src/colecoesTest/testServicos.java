package colecoesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		int id = servico.adicionaAlbum("album teste", 2);
		Album album = servico.getAlBumPeloId(id);
		assertEquals("album teste", album.getNome());
		assertEquals(1, album.getId());
	}
}
