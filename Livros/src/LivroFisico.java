public class LivroFisico extends Livro {

    private static final double VALORIMPPAG = 0.03;
    private double vlrEncadernacao;

    LivroFisico (double encadernacao, int paginas){
        this.vlrEncadernacao = encadernacao;
        this.quantPaginas = paginas;
    }

    @Override
    public double precoVenda(){
        return precoBase + calculaDireitosAutorais() + precoImpressao() + vlrEncadernacao;
    }

    private double precoImpressao(){
        return quantPaginas * VALORIMPPAG;
    }
    
}
