package colecoes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;

public class Colecao {
	private String nome;
	//private String[] figurinhasNovas;
	//private String[] figRepetidas;
	private int idAlbum;
	
	List<String> figurinhasNovas  = new ArrayList<String>();
	List<String> figRepetidas  = new ArrayList<String>();
	
	public Colecao(int idAlbum, String nomeColecao) {
		this.idAlbum = idAlbum;
		this.nome = nomeColecao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
/*
	public String[] getFigurinhas() {
		return figurinhasNovas;
	}

	public void setFigurinhas(String[] figurinhas) {
		this.figurinhasNovas = figurinhas;
	}

	public String[] getFigRepetidas() {
		return figRepetidas;
	}

	public void setFigRepetidas(String[] figRepetidas) {
		this.figRepetidas = figRepetidas;
	}
*/
	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	
	
	public void adicionarFigurinhaNaColecao(String[] figurinhas) {
		/*
		for(int i = 0; i < this.figurinhasNovas.size(); i++) {
			for(int a = 0; a < figurinhas.length; a++) {
				if(this.figurinhasNovas.get(i).equals(figurinhas[a])) {
					this.figRepetidas.add(figurinhas[a]);
				}
			}
		}
		*/	
		
		
		List<String> novas  = new ArrayList<String>();
		List<String> repetidas  = new ArrayList<String>();
		
		if(this.figurinhasNovas.size() == 0) {
			for(int i = 0; i < figurinhas.length; i++) {
				this.figurinhasNovas.add(figurinhas[i]);
				novas.add(figurinhas[i]);
			}
		}
		else {
			boolean figurinhaExiste = false;
			
			for(int c = 0; c < this.figurinhasNovas.size(); c++) {
				figurinhaExiste = false;
				for(int g = 0; g < figurinhas.length; g++) {
					if(this.figurinhasNovas.get(g).equals(figurinhas[c])) {
						figurinhaExiste = true;
						break;
					}
				}
				if(figurinhaExiste) {
					this.figRepetidas.add(figurinhas[c]);
					repetidas.add(figurinhas[c]);
				}
				else {
					this.figurinhasNovas.add(figurinhas[c]);
					novas.add(figurinhas[c]);
				}
			}
			
		}
		System.out.print("Novas: ");
		for(int i = 0; i < novas.size(); i++) {
			System.out.print(novas.get(i) + " ");
		}
		System.out.println(" ");
		
		System.out.print("Repetidas: ");
		for(int i = 0; i < repetidas.size(); i++) {
			System.out.print(repetidas.get(i) + " ");
		}
		System.out.println(" ");
		
	}
		
}
