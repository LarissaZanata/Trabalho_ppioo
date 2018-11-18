package colecoes;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

// Classe principal que implementa uma interface orientada a comandos com o
// usu�rio.
//
// Para executar este programa pressione F6 no netbeans.
//
// Para executar este programa no terminal construa o projeto (F11 no
// netbeans), abra o terminal e mude para o diret�rio do projeto e execute:
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
            // Cada comando deve efetuar uma chamada de m�todo de servico
            // ex: service.novoAlbum(parametros...)
            // Se o c�digo dentro de um case ficar muito extenso, voc� deve
            // criar um novo m�todo, ex executaComandoNovoAlbum
            String array[] = parsearEntrada(comando);
            
            switch (array[0]) {
            	case "novo-album":
            		int nFig = Integer.parseInt(array[2]);
            		int id = servico.adicionaAlbum(array[1], nFig);
            		saida.println("Album " + id + " criado.");
            		break;
            	case "albuns":
            		List<Album> lista = servico.retornaListaAlbuns();
            		System.out.println("------Albuns------");
            		if(lista.size()!= 0) {
            			for(int i= 0; i < lista.size(); i++) {
                			System.out.println(lista.get(i).getNome());
                		}
            		}
            		else {
            			System.out.println("Ainda n�o existe albuns cadastrados.");
            		}
            		
            		break;
            	case "mostrar":
            		int ID = Integer.parseInt(array[1]);
            		Album album = servico.mostrarAlbumPeloId(ID);
            		if(album != null) {
            			System.out.println("----Informa��es do Album----");
        				System.out.println("T�tulo: " + album.getNome());
        				System.out.println("Quantidade de figurinhas: " + album.getQuantidade());
            		}
            		break;
            	case "nova-colecao":
            		int idAlbum = Integer.parseInt(array[1]);
            		String nomeColecao = array[2].trim();
            		boolean colecaoJaExiste = servico.adicionarNovaColecao(idAlbum, nomeColecao);
            		if(colecaoJaExiste) {
            			saida.println("Esta colecao j� existe para o album " + idAlbum);
            		}
            		else {
            			saida.println("Colecao " + idAlbum + "/"+ array[2] + " criada.");
            		}
            		break;
                case "sair":
                    break loop;
                default:
                    saida.println("Comando inv�lido: " + comando);
            }
        }
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
    
    

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Outra implementa��o de ColecoesService, como por exemplo uma que
        // executa remotamente, pode ser usada sem que o c�digo de interface do
        // usu�rio tenha que ser alterado.
        //
        // Uma inst�ncia de classe que implementa ColecoesDao deve ser passada
        // como par�metro ao inv�s de null.
        Dao dao = new Dao();
        ColecoesServico servico = new LocalColecoesServico(dao);
        Main main = new Main(entrada, servico, System.out);
        main.executa();
    }
}
