public class LivroVirtual extends Livro {
    @Override
    public double precoVenda(){
        return precoBase + calculaDireitosAutorais();
    }
    
}
