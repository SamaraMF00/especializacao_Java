import java.util.ArrayList;
import java.util.List;

public class Autor {
    public String nome;
    private List<Livro> livros; 

    Autor(String nome){
        livros = new ArrayList<Livro>();
        this.nome = nome;
    }

    public double direitoAutoral(Livro livro){
       return livro.calculaDireitosAutorais();    
    }

    public double direitoAutoral(){
        double vlrTotal = 0;
        
        for (int i = 0; i < livros.size(); i++){
            vlrTotal += livros.get(i).calculaDireitosAutorais();
        }

        return vlrTotal;
     }

     public void adicionaLivro(Livro livro){
        livros.add(livro);
     }
}
