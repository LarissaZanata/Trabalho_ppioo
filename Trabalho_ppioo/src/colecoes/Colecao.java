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
	
	List<String> AuxiliarNovas  = new ArrayList<String>();
	List<String> AuxiliarRepetidas  = new ArrayList<String>();
	
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

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	

	public void adicionarFigurinhaNaColecao(String[] figurinhas) {
		
		if(this.figurinhasNovas.size() == 0) {
			for(int i = 0; i < figurinhas.length; i++) {
				this.figurinhasNovas.add(figurinhas[i]);
				AuxiliarNovas.add(figurinhas[i]);
			}
		}
		else {
		boolean figurinhaExiste = false;
		for(int g = 0; g < figurinhas.length; g++) {
			figurinhaExiste = false;
			for(int c = 0; c < this.figurinhasNovas.size(); c++) {
				if(this.figurinhasNovas.get(c).equals(figurinhas[g])) {
					figurinhaExiste = true;
					break;
				}
			}
			if(figurinhaExiste) {
				this.figRepetidas.add(figurinhas[g]);
				AuxiliarRepetidas.add(figurinhas[g]);
			}
			else {
				this.figurinhasNovas.add(figurinhas[g]);
				AuxiliarNovas.add(figurinhas[g]);
			}
		}
			
	}
		//imprime o que houve de novas e repetidas;
		System.out.print("Novas: ");
		for(int i = 0; i < AuxiliarNovas.size(); i++) {
			System.out.print(AuxiliarNovas.get(i) + " ");
		}
		System.out.println(" ");
		
		System.out.print("Repetidas: ");
		for(int i = 0; i < AuxiliarRepetidas.size(); i++) {
			System.out.print(AuxiliarRepetidas.get(i) + " ");
		}
		System.out.println(" ");
	}
	
	public List<String> GetfigNovas(){
		return this.figurinhasNovas;
	}
	
	public List<String> GetfigRepetidas(){
		return this.figRepetidas;
	}
}
