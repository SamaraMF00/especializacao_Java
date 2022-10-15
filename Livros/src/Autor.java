import java.util.ArrayList;
import java.util.List;

public class Autor {
    public String nome;
    private List<Livro> livros;

    Autor(String nome) {
        livros = new ArrayList<Livro>();
        this.nome = nome;
    }

    public double direitoAutoral(Livro livro) {
        return livro.calculaDireitosAutorais();
    }

    public double direitoAutoral() {
        double vlrTotal = 0;

        for (int i = 0; i < livros.size(); i++) {
            vlrTotal += livros.get(i).calculaDireitosAutorais();
        }

        return vlrTotal;
    }

    public void adicionaLivro(Livro livro) {
        livros.add(livro);
    }

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
}
