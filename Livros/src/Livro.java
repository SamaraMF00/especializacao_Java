public class Livro {

    private static final double PERCDIREIAUTORAIS = 0.08;
    protected double precoBase;
    protected String titulo;
    protected Autor autor;
    protected int quantPaginas;
    protected String codigo;
    protected int copiasVendidas;

    public double precoVenda(){
        return 0;
    }

    public double calculaDireitosAutorais(){
        return this.precoBase * PERCDIREIAUTORAIS * copiasVendidas; 
    }

}
