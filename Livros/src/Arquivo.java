import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public List<Autor> carregarDadosLivro(String nomeArquivo) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        String linha = br.readLine();
        List<Autor> autores  = new ArrayList<Autor>();

        while(linha != null) {
           String[] vetLinha = linha.split(";");
           Autor autor = new Autor(vetLinha[2]);
            if (linha.contains(";F;")) {
               LivroFisico livroF = new LivroFisico(Double.parseDouble(vetLinha[5]), Integer.parseInt(vetLinha[6]));
               livroF.codigo = vetLinha[0];
               livroF.titulo = vetLinha[1];
               livroF.autor = autor;
               livroF.precoBase = Double.parseDouble(vetLinha[4]);
               if (vetLinha.length == 8)
                  livroF.copiasVendidas = Integer.parseInt(vetLinha[7]);
               autor.adicionaLivro(livroF);
            }
            else{
                LivroVirtual livroV = new LivroVirtual();
                livroV.codigo = vetLinha[0];
                livroV.titulo = vetLinha[1];
                livroV.autor = autor;
                livroV.precoBase = Double.parseDouble(vetLinha[4]);
                livroV.copiasVendidas = Integer.parseInt(vetLinha[5]);
                autor.adicionaLivro(livroV);
            }
            autores.add(autor);
            linha = br.readLine();
        }
        
        br.close();
        return autores;
    }
}
