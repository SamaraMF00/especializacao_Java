import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LojaVirtual {

    static Scanner entrada = new Scanner(System.in);
    private List<Livro> livros = new ArrayList<Livro>();
    private List<Autor> autores = new ArrayList<Autor>();
    Collator collator = Collator.getInstance(new Locale("pt", "BR"));

    public void carregarDadosLivro(String nomeArquivo) throws Exception {
        Path path = Paths.get(nomeArquivo);
        Scanner scanner = new Scanner(path, "UTF-8");

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] vetLinha = linha.split(";");

            Autor autor = buscaAutor(vetLinha[2]);

            if (autor == null)
                autor = new Autor(vetLinha[2]);

            if (linha.contains(";F;")) {
                LivroFisico livroF = new LivroFisico(Double.parseDouble(vetLinha[5]), Integer.parseInt(vetLinha[6]));
                livroF.codigo = vetLinha[0];
                livroF.titulo = vetLinha[1];
                livroF.autor = autor;
                livroF.precoBase = Double.parseDouble(vetLinha[4]);
                if (vetLinha.length == 8)
                    livroF.copiasVendidas = Integer.parseInt(vetLinha[7]);
                autor.adicionaLivro(livroF);
                livros.add(livroF);
            } else {
                LivroVirtual livroV = new LivroVirtual();
                livroV.codigo = vetLinha[0];
                livroV.titulo = vetLinha[1];
                livroV.autor = autor;
                livroV.precoBase = Double.parseDouble(vetLinha[4]);
                livroV.copiasVendidas = Integer.parseInt(vetLinha[5]);
                autor.adicionaLivro(livroV);
                livros.add(livroV);
            }
            autores.add(autor);
        }

        scanner.close();
    }

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

    public Autor buscaAutor(String nomeAutor) {
        nomeAutor = nomeAutor.toUpperCase();
        Autor autorEncontrado = null;

        for (int i = 0; i < this.autores.size(); i++) {
            if (this.autores.get(i).nome.compareTo(nomeAutor) == 0) {
                autorEncontrado = this.autores.get(i);
                break;
            }
        }
        return autorEncontrado;
    }

    public void registrarVenda(Livro livroVenda, int quant) {
        livroVenda.copiasVendidas += quant;
    }
}
