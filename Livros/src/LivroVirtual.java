public class LivroVirtual extends Livro {
    @Override
    public double precoVenda(){
        return precoBase;
    }
  
    @Override
    public String toString(){
        StringBuilder livro = new StringBuilder("\n\nDados do livro " + this.titulo);
        livro.append("\n----------------------------\n");
        livro.append("Tipo --> Digital\n");
        livro.append("Código --> "+ this.codigo + "\n");
        livro.append("Nome do autor --> "+ this.autor.nome + "\n");
        livro.append("Preço base --> R$ "+ String.format("%.2f", this.precoBase) + "\n");
        livro.append("Preço de venda --> R$ "+ String.format("%.2f", this.precoVenda()) + "\n");
        livro.append("Cópias vendidas --> "+ this.copiasVendidas + "\n");
        livro.append("Direitos autorais --> R$ "+ String.format("%.2f", this.autor.direitoAutoral(this)) + "\n");

        return livro.toString();
    }    

}
