import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LojaVirtual {

//#region variavéis locais

    private List<Livro> livros = new ArrayList<Livro>();
    private List<Autor> autores = new ArrayList<Autor>();
    private Collator collator = Collator.getInstance(new Locale("pt", "BR"));

//#endregion

//#region métodos

/**
 * Método responsável pelo carregamento de um arquivo com dados de livros.
 * Guarda os dados dos livros, separando físicos de digitais e os dados do autor.
 * @param nomeArquivo caminho do arquivo
 * @throws Exception caminho não encontrado
 */   
    public void carregarDadosLivro(String nomeArquivo) throws Exception {
        Path path = Paths.get(nomeArquivo);
        Scanner scanner = new Scanner(path, "UTF-8");

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] vetLinha = linha.split(";");

            Autor autor = retornaAutor(vetLinha[2]);
            Livro novoLivro = null;

            if (linha.contains(";F;"))
               novoLivro = criaLivroFisico(vetLinha, autor);
            else
               novoLivro = criaLivroDigital(vetLinha, autor);

            autor.adicionaLivro(novoLivro); 

            autores.add(autor);
            livros.add(novoLivro);
        }
        scanner.close();
    }

/**
 * Busca os dados de um autor, caso não exista, cria um novo.
 * @param nomeAutor nome do autor
 * @return Autor (já existênte ou um novo objeto)
 */
    private Autor retornaAutor(String nomeAutor) {
        Autor autor = buscaAutor(nomeAutor);

        if (autor == null)
            autor = new Autor(nomeAutor);
        return autor;
    }

/**
 * Método reponsável por armazenar os dados de livros digitais.
 * @param vetLinha dados do livro [código, titulo, autor, "D", preço base, cópias vendidas] 
 * @param autor autor do livro
 * @return objeto LivroDigital
 */
    private LivroDigital criaLivroDigital(String[] vetLinha, Autor autor) {
        LivroDigital livroD = new LivroDigital();
        livroD.codigo = vetLinha[0];
        livroD.titulo = vetLinha[1];
        livroD.autor = autor;
        livroD.precoBase = Double.parseDouble(vetLinha[4]);
        livroD.copiasVendidas = Integer.parseInt(vetLinha[5]);
        return livroD;
    }

/**
 * Método reponsável por armazenar os dados de livros físico.
 * @param vetLinha dados do livro [código, titulo, autor, "D", preço base, valor encadernação, páginas, cópias vendidas] 
 * @param autor autor do livro
 * @return objeto LivroFisico
 */
    private LivroFisico criaLivroFisico(String[] vetLinha, Autor autor) {
        LivroFisico livroF = new LivroFisico(Double.parseDouble(vetLinha[5]), Integer.parseInt(vetLinha[6]));
        livroF.codigo = vetLinha[0];
        livroF.titulo = vetLinha[1];
        livroF.precoBase = Double.parseDouble(vetLinha[4]);
        livroF.copiasVendidas = Integer.parseInt(vetLinha[7]);
        livroF.autor = autor;
        return livroF;
    }

/**
 * Busca um livro nos dados já armazenados
 * @param titLivro título do livro
 * @return objeto Livro ou "null" caso não encontrado
 */
    public Livro buscaLivro(String titLivro) {
        collator.setStrength(Collator.PRIMARY);
        titLivro = titLivro.toUpperCase();
        Livro livroEncontrado = null;

        for (int i = 0; i < this.livros.size(); i++) {
            if (collator.compare(this.livros.get(i).titulo, titLivro) == 0) {
                livroEncontrado = this.livros.get(i);
                break;
            }
        }
        return livroEncontrado;
    }

/**
 * Busca um autor nos dados já armazenados
 * @param nomeAutor nome do autor
 * @return objeto Autor ou "null" caso não encontrado
 */
    public Autor buscaAutor(String nomeAutor) {
        collator.setStrength(Collator.PRIMARY);
        nomeAutor = nomeAutor.toUpperCase();
        Autor autorEncontrado = null;

        for (int i = 0; i < this.autores.size(); i++) {
            if (collator.compare(this.autores.get(i).nome, nomeAutor) == 0) {
                autorEncontrado = this.autores.get(i);
                break;
            }
        }
        return autorEncontrado;
    }

/**
 * Aumenta a quantidade de cópias vendidas de um livro
 * @param livroVenda livro que será registrado
 * @param quant quantidade vendida
 */
    public void registrarVenda(Livro livroVenda, int quant) {
        livroVenda.copiasVendidas += quant;
    }

//#endregion

}
