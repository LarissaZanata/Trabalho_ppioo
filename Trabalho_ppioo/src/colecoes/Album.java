package colecoes;

import java.util.concurrent.atomic.AtomicInteger;

public class Album {
	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private String nome;
	private int quantidade;

	public Album(String nome, int quant) {
		this.nome = nome;
		this.quantidade = quant;
		this.id = count.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void exibeAlbumCriado() {
		System.out.println("Album " + this.getId() + " criado.");
		
	}
	

}
