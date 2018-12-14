package colecoes;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

// Classe principal que implementa uma interface orientada a comandos com o
// usuário.
//
// Para executar este programa pressione F6 no netbeans.
//
// Para executar este programa no terminal construa o projeto (F11 no
// netbeans), abra o terminal e mude para o diretório do projeto e execute:
// java -jar dist/Colecoes.jar
public class Main {
    final static String PROMPT = "> "; 
    final PrintStream saida;
    final Scanner entrada;
    final ColecoesServico servico;
    String cmd;

    public Main(Scanner entrada, ColecoesServico servico, PrintStream saida) {
        this.entrada = entrada;
        this.servico = servico;
        this.saida = saida;
    }

    public void executa() {
        loop:
        while (true) {
            String comando = leComand();
            // Cada comando deve efetuar uma chamada de método de servico
            // ex: service.novoAlbum(parametros...)
            // Se o código dentro de um case ficar muito extenso, você deve
            // criar um novo método, ex executaComandoNovoAlbum
            String array[] = parsearEntrada(comando);
            
            switch (array[0]) {
            	case "novo-album":
            		try {
            			int nFig = Integer.parseInt(array[2]);
                		int id = servico.adicionaAlbum(array[1], nFig);
                		saida.println("Album " + id + " criado.");
            		}catch( ArrayIndexOutOfBoundsException e) {
            			System.out.println("Algum parametro não foi digitado corretamente, por favor tente novamente.");
            		}catch(NumberFormatException e) {
            			System.out.println("A ordem dos parametros está incorreta, por favor tente novamente.");
            		}
            		break;
            	case "albuns":
            		List<Album> lista = servico.retornaListaAlbuns();
            		List<Colecao> listacolecao = servico.retornaListaDeColecao();
            		System.out.println("------Albuns------");
            		if(lista.size()!= 0) {
            			for(int i= 0; i < lista.size(); i++) {
                			System.out.println(i+1 + "- " +lista.get(i).getNome());
                		}
            		}
            		else {
            			System.out.println("Ainda não existe albuns cadastrados.");
            		}
            		
            		break;
            	case "mostrar":
            		try {
                		int ID = Integer.parseInt(array[1]);
        				Album album = servico.mostrarAlbumPeloId(ID);
                				if(album != null) {
                					System.out.println("----Informações do Album----");
                					System.out.println("Título: " + album.getNome());
                					System.out.println("Quantidade de figurinhas: " + album.getQuantidade());
                				}
            		}catch( ArrayIndexOutOfBoundsException e) {
            			System.out.println("Algum parametro não foi digitado corretamente, por favor tente novamente.");
            		}

            		break;
            	case "nova-colecao":
            		try {
            			int idAlbum = Integer.parseInt(array[1]);
                		String nomeColecao = array[2].trim();
                		boolean colecaoJaExiste = servico.adicionarNovaColecao(idAlbum, nomeColecao);
                		if(colecaoJaExiste) {
                			saida.println("Esta colecao já existe para o album " + idAlbum);
                		}
                		else {
                			saida.println("Colecao " + idAlbum + "/"+ array[2] + " criada.");
                		}
            		}catch(NumberFormatException e) {
            			System.out.println("A ordem dos parametros está incorreta, por favor tente novamente.");
            		}catch(ArrayIndexOutOfBoundsException e) {
            			System.out.println("Algum parametro não foi digitado corretamente, por favor tente novamente.");
            		}
            		break;
            	case "adicionar":
            		boolean figurinhasAdicionadas = false;
            		try {
            			int idDoAlbum =  Integer.parseInt(array[1]);
                		String nomColecao = array[2].trim();
                		String figurinhas = array[3].trim();
                		figurinhasAdicionadas = servico.adicionarFigurinhas(idDoAlbum, nomColecao, figurinhas);
                		if(!figurinhasAdicionadas) {
                			System.out.println("Pode ser que a colecao " + nomColecao + " ainda não exista!\n Verfique sua existencia ou crie uma nova coleção");
                		}
            		}catch(NumberFormatException e) {
            			System.out.println("A ordem dos parametros está incorreta, por favor tente novamente.");
            		}catch(ArrayIndexOutOfBoundsException e) {
            			System.out.println("Algum parametro não foi digitado corretamente, por favor tente novamente.");
            		}
            		break;
            	case "mostrar-colecao":
            		int id_Album = Integer.parseInt(array[1]);
    				Album albumC = servico.mostrarAlbumPeloId(id_Album);
    				Colecao colecao;
    				int porcentagemAtual, porcentagemFaltantes;
    				int figsAtuais[] = new int[albumC.getQuantidade()];
    				int figsFaltantes[] = new int[albumC.getQuantidade()];
    				
    				porcentagemAtual = servico.calculaPorcentagemFigurinhasAtual(Integer.valueOf(array[1]), array[2]);
    				porcentagemFaltantes = servico.calculaPorcentagemFigurinhasFaltantes(Integer.valueOf(array[1]), array[2]);
    				figsAtuais = servico.retornaFigurinhasDaColecao(Integer.valueOf(array[1]), array[2]);
    				figsFaltantes = servico.retornaFigurinhasDaColecaoFaltantes(Integer.valueOf(array[1]), array[2]);
    				
    				System.out.println("Album: " + albumC.getNome());
    				System.out.println("Titulo: " + array[2]);
    				System.out.print("Presentes ("+porcentagemAtual+"%): ");
    				imprimeVetor(figsAtuais);
    				System.out.print("Faltantes ("+porcentagemFaltantes+"%): ");
    				imprimeVetor(figsFaltantes);
            		break;
                case "sair":
                    break loop;
                default:
                    saida.println("Comando inválido: " + comando);
            }
        }
    }

    void imprimeVetor(int[] vetor) {
    	for(int i = 0; i < vetor.length; i++) {
    		if(vetor[i] != -1)
    		System.out.print(vetor[i] + " ");
    	}
    	System.out.println("");
    }
    
    String leComand() {
        while (true) {
            saida.print(PROMPT);;
            String comando = entrada.nextLine().trim();
            if (!comando.isEmpty()) {
                return comando;
            }
        }
    }
    
    String[] parsearEntrada(String comando) {
    	String array[] = comando.split(" ");
    	return array;
    }
    
    void exibirMenu() {
    	System.out.println("--------Digite um comando como alguns dos modelos abaixo--------");
    	System.out.println("");
    	System.out.println("Adicionar Album:  novo-album nome-do-album Nº-de-Figurinhas");
    	System.out.println("Listar albuns existentes:  albuns");
    	System.out.println("Mostrar informações sobre algum album:  mostrar iD-Do-Album");
    	System.out.println("Inserir uma coleção:  nova-colecao id-Album nome-Colecao");
    	System.out.println("Adicionar figurinhas: adicionar id-album nome-colecao figurinha-separadas-por-virgura");
    	System.out.println("");
    }
    
    

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Outra implementação de ColecoesService, como por exemplo uma que
        // executa remotamente, pode ser usada sem que o código de interface do
        // usuário tenha que ser alterado.
        //
        // Uma instância de classe que implementa ColecoesDao deve ser passada
        // como parâmetro ao invés de null.
        Dao dao = new Dao();
        ColecoesServico servico = new LocalColecoesServico(dao);
        Main main = new Main(entrada, servico, System.out);
        main.executa();
    }
}
