public class Livro {

//#region atributos
    private static final double PERCDIREIAUTORAIS = 0.08;
    protected double precoBase;
    protected String titulo;
    protected Autor autor;
    protected int quantPaginas;
    protected String codigo;
    protected int copiasVendidas;
//#endregion

//#region métodos

/**
 * Método responsável por calcular o preço de venda de cada livro de acordo com seus gastos.
 * @return preço de venda do livro
 */
    public double precoVenda(){
        return 0;
    }

/**
 * Calcula o valor dos direitos autorais adquiridos em uma obra.
 * @return valor dos direitos autorais do livro
 */
    public double calculaDireitosAutorais(){
        return this.precoBase * PERCDIREIAUTORAIS * copiasVendidas; 
    }

//#endregion

}
