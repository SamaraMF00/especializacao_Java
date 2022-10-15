public class LivroFisico extends Livro {

//#region atributos
    private static final double VALORIMPPAG = 0.03;
    private double vlrEncadernacao;
//#endregion

//#region construtor
    LivroFisico (double encadernacao, int paginas){
        this.vlrEncadernacao = encadernacao;
        this.quantPaginas = paginas;
    }
//#endregion

//#region métodos

    @Override
    public double precoVenda(){
        return precoBase + precoImpressao() + vlrEncadernacao;
    }

/**
 * Calcula o preço gasto com a impressão de um livro físico.
 * @return valor da impressão
 */
    private double precoImpressao(){
        return quantPaginas * VALORIMPPAG;
    }
   
    @Override
    public String toString(){
        this.toString();

        StringBuilder livro = new StringBuilder("\n\nDados do livro " + this.titulo);
        livro.append("\n\n---------------------------\n");
        livro.append("Tipo --> Físico\n");
        livro.append("Código --> "+ this.codigo + "\n");
        livro.append("Nome do autor --> "+ this.autor.nome + "\n");
        livro.append("Preço base --> R$ "+ String.format("%.2f", this.precoBase) + "\n");
        livro.append("Preço de venda --> R$ "+ String.format("%.2f", this.precoVenda()) + "\n");
        livro.append("Cópias vendidas --> "+ this.copiasVendidas + "\n");
        livro.append("Quantidade de páginas --> "+ this.quantPaginas + "\n");
        livro.append("Valor encadernação --> R$ "+ String.format("%.2f", this.vlrEncadernacao) + "\n");
        livro.append("Direitos autorais --> R$ "+ String.format("%.2f", this.autor.direitoAutoral(this)) + "\n");

        return livro.toString();
    }

//#endregion
}
