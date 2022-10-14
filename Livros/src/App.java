import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Arquivo arq = new Arquivo();
        List<Autor> autores = arq.carregarDadosLivro("C:/Users/Cliente Vip Infomac/Desktop/PUC/PM/TPM/Livros/Livros/src/LIVROS_PM.txt");
        System.out.println(autores.get(0).direitoAutoral());
    }
}
