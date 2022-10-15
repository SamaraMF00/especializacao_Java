import java.util.ArrayList;
import java.util.List;

public class Autor {

//#region atributos
    public String nome;
    private List<Livro> livros;
//#endregion

//#region construtor
    Autor(String nome) {
        livros = new ArrayList<Livro>();
        this.nome = nome;
    }
//#endregion

//#region métodos

/**
 * Busca o valor de direito autoral adquirido em uma obra do autor.
 * @param livro livro a ser verificado
 * @return valor de direito autoral em um livro
 */
    public double direitoAutoral(Livro livro) {
        return livro.calculaDireitosAutorais();
    }

/**
 * Calcula o valor de direito autoral TOTAL do autor.
 * Considera todas as obras vendidas.
 * @return valor TOTAL de direito autoral
 */
    public double direitoAutoral() {
        double vlrTotal = 0;

        for (int i = 0; i < livros.size(); i++) {
            vlrTotal += livros.get(i).calculaDireitosAutorais();
        }

        return vlrTotal;
    }

/**
 * Atribui um novo livro ao autor
 * @param livro livro a ser atribuido ao autor
 */
    public void adicionaLivro(Livro livro) {
        livros.add(livro);
    }

/**
 * Busca a quantidade de livros do autor.
 * @return quantidade de livros registradas para o autor
 */
    public int quantidadeLivros() {
        return livros.size();
    }

    @Override
    public String toString() {
        StringBuilder livro = new StringBuilder("\n\nDados do autor " + this.nome);
        livro.append("\n----------------------------\n");
        livro.append("Quantidade de livros --> " + this.quantidadeLivros() + "\n");
        livro.append("Livros --> ");

        for (int i = 0; i < livros.size(); i++) {
            livro.append(livros.get(i).titulo);
            if (i != livros.size() - 1)
                livro.append(", ");
        }

        livro.append("\nValor total de direito autoral --> R$ " + String.format("%.2f", this.direitoAutoral()) + "\n");

        return livro.toString();
    }
//#endregion
}
