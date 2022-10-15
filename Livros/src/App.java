import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

//#region variáveis
    private static final String CAMINHOARQUIVOLEITURA = "C:/Users/Cliente Vip Infomac/Desktop/PUC/PM/TPM/especializacao_Java/Livros/src/LIVROSPM.txt";
    private static LojaVirtual lojaVirt = new LojaVirtual();
    static Scanner entrada = new Scanner(System.in, "UTF-8");
//#endregion

    public static void main(String[] args) throws Exception {
        int op = 0;
        carregarArquivoLivros();
        do {
            op = menuOpcoes();
            carregaOpcao(op);
        } while (op != 0);
    }

//#region métodos

/**
 * Executa uma ação com base na escolha do usuário pelo menu.
 * @param op opção escolhida no menu
 */    
    private static void carregaOpcao(int op) {
        switch (op) {
            case 1:
                exibeDadosLivro();
                break;
            case 2:
                exibeDadosAutor();
                break;
            case 3:
                registrarVenda();
                break;
            default:
                op = 0;
                System.out.println("Sessão encerrada.");
        }
    }

/**
 * Método responsável por verificar se um objeto é nulo ou não. 
 * Caso seja null: exibe mensagem ao usuário.
 * Caso não seja null: imprime o "toString" do objeto.
 * @param obj objeto para verificação
 */
    private static void exibeDados(Object obj) {
        if (obj == null)
            System.out.println("Dados não encontrados.");
        else
            System.out.println(obj.toString());
    }

/**
 * Método para exibir os dados completos de um autor.
 * Caso o autor não seja encontrado irá imprimir "Dados não encontrados." 
 */
    private static void exibeDadosAutor() {
        System.out.println("Digite o nome do autor.");
        String nomeAutor = entrada.next();
        Autor autorEncontrado = lojaVirt.buscaAutor(nomeAutor);
        exibeDados(autorEncontrado);
    }

/**
 * Busca por um livro através do título digitado pelo usuário.
 * @return Livro caso seja encontrado ou null caso não seja encontrado.
 */
    private static Livro buscaLivro() {
        System.out.println("Digite o título do livro.");
        String titLivro = entrada.nextLine();
        return lojaVirt.buscaLivro(titLivro);
    }

/**
 * Método para exibir os dados completos de um livro.
 * Caso o autor não seja encontrado irá imprimir "Dados não encontrados." 
 */
    private static void exibeDadosLivro() {
        Livro livroEncontrado = buscaLivro();
        exibeDados(livroEncontrado);
    }

/**
 * Registro de vendas de um livro.
 * É solicitado o título do livro e quantidade ao usuário.
 * Retona mensagem de sucesso ou falha caso os dados estejam incorretos.
 */
    private static void registrarVenda() {
        Livro livroVenda = buscaLivro();

        if (livroVenda != null) {
            System.out.println("Digite a quantidade de livros.");
            int quant = capturaOpcao();

            if (quant == -1)
               System.out.println("Quantidade inválida.");
            else{
               lojaVirt.registrarVenda(livroVenda, quant);
               System.out.println("Venda registrada com sucesso.");
            }

        } else
            System.out.println("Livro não encontrado.");
    }

/**
 * Método responsável por capturar a opção de entrada do tipo "int" do usuário. 
 * @return int da opção digitada ou 0 caso ocorra erro.
 */ 
    private static int capturaOpcao() {
        try {
            int op = entrada.nextInt();
            entrada.nextLine();
            return op;
        } catch (InputMismatchException e) {
            return 0;
        }
    }

/**
 * Menu de opções para escolha de uma ação pelo usuário.
 * @return int da opção escolhida pelo usuário ou 0 caso ocorra erro.
 */
    private static int menuOpcoes() {
        System.out.println("\nGerenciamento de livros");
        System.out.println("---------------------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Visualizar dados de um livro");
        System.out.println("2 - Visualizar dados de um autor");
        System.out.println("3 - Registrar venda de um livro");
        System.out.println("0 - Cancelar");

        return capturaOpcao();
    }

/**
 * Carrega um arquivo com livros para leitura.
 * Caminho do arquivo é fixo e local 
 * @throws Exception Arquivo não encontrado
 */
    private static void carregarArquivoLivros() throws Exception {
        lojaVirt.carregarDadosLivro(CAMINHOARQUIVOLEITURA);
    }

//#endregion
}
