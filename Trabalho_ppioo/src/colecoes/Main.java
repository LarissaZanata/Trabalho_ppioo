package colecoes;

import java.io.PrintStream;
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
            		int nFig = Integer.parseInt(array[2]);
            		int id = servico.adicionaAlbum(array[1], nFig);
            		saida.println("Album " + id + " criado.");
            		break;
            	case "albuns":
            		servico.mostrarAlbuns();
            		break;
            	case "mostrar":
            		int ID = Integer.parseInt(array[1]);
            		Album album = servico.mostrarAlbumPeloId(ID);
            		if(album != null) {
            			System.out.println("----Informações do Album----");
        				System.out.println("Título: " + album.getNome());
        				System.out.println("Quantidade de figurinhas: " + album.getQuantidade());
            		}
            		break;
                case "sair":
                    break loop;
                default:
                    saida.println("Comando inválido: " + comando);
            }
        }
    }

    String leComand() {
        while (true) {
            saida.print(PROMPT);
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
