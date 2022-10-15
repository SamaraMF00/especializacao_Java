import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final String CAMINHOARQUIVOLEITURA = "C:/Users/Cliente Vip Infomac/Desktop/PUC/PM/TPM/especializacao_Java/Livros/src/LIVROSPM.txt";
    private static LojaVirtual lojaVirt = new LojaVirtual();
    static Scanner entrada = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) throws Exception {
        carregarArquivoLivros();
        int op;
        do {
            op = menuOpcoes();
            carregaOpcao(op);
        } while (op != 0);
    }

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

    private static void exibeDadosAutor() {
        System.out.println("Digite o nome do autor.");
        String nomeAutor = entrada.next();
        Autor autorEncontrado = lojaVirt.buscaAutor(nomeAutor);
        if (autorEncontrado == null)
            System.out.println("Autor não encontrado.");
        else
            System.out.println(autorEncontrado.toString());
    }

    private static Livro buscaLivro() {
        System.out.println("Digite o título do livro.");
        String titLivro = entrada.nextLine();
        return lojaVirt.buscaLivro(titLivro);
    }

    private static void exibeDadosLivro() {
        Livro livroEncontrado = buscaLivro();
        if (livroEncontrado == null)
            System.out.println("Livro não encontrado.");
        else
            System.out.println(livroEncontrado.toString());
    }

    private static void registrarVenda() {
        Livro livroVenda = buscaLivro();
        if (livroVenda != null) {
            System.out.println("Digite a quantidade de livros.");
            int quant = entrada.nextInt();
            lojaVirt.registrarVenda(livroVenda, quant);
            System.out.println("Venda registrada com sucesso.");
        } else
            System.out.println("Livro não encontrado.");
    }

    private static int menuOpcoes() {
        System.out.println("\nGerenciamento de livros");
        System.out.println("---------------------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Visualizar dados de um livro");
        System.out.println("2 - Visualizar dados de um autor");
        System.out.println("3 - Registrar venda de um livro");
        System.out.println("0 - Cancelar");

        try {
            int op = entrada.nextInt();
            entrada.nextLine();
            return op;
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    private static void carregarArquivoLivros() throws Exception {
        lojaVirt.carregarDadosLivro(CAMINHOARQUIVOLEITURA);
    }
}
