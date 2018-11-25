package colecoesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

import org.junit.Test;

import colecoes.Album;
import colecoes.Colecao;
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

	@Test
	public void testNovaColecao() {
		Dao dao = new Dao();
		ColecoesServico servico = new LocalColecoesServico(dao);
		//a colecao não deve existir para o id 1 ainda
		boolean colecaoJaExiste = servico.adicionarNovaColecao(1, "Principal");
		assertEquals(false, colecaoJaExiste);
	}
	
	@Test
	public void testNovaColecaoJaExiste() {
		Dao dao = new Dao();
		ColecoesServico servico = new LocalColecoesServico(dao);
		
		servico.adicionarNovaColecao(1, "Teste");
		boolean colecaoJaExiste = servico.adicionarNovaColecao(1, "Teste");
		//foi adicionado 2 colecoes com mesmo nome para o mesmo id, na segunda vez a coleção já deve existir e voltar true.
		assertEquals(true, colecaoJaExiste);
		
	}
}
