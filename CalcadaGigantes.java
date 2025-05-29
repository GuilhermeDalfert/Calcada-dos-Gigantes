import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CalcadaGigantes
{
  public static void main(String[] args) {
    Grafo g = lêArquivo();
   
  }

  public static Grafo lêArquivo (){
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite o nome do arquivo .txt: ");
    String arquivo = teclado.nextLine();
    File caso = new File(arquivo);
    Grafo g = new Grafo();
    HashMap <Character, Integer> valLetra = new HashMap<>();
    valLetra.put('S', 1);
    for (int k = 0; k < 26; k++)
    {
      valLetra.put((char)('a'+ k),k+1);
    }
    try (Scanner scan = new Scanner(caso);)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            scan.nextLine();
            String nome = null;
            for (int i = 0; i < x; i++)
            {
                String linha = scan.nextLine();
                for (int j = 0; j < y; j++)
                {
                  char letra = linha.charAt(j);
                  nome = i +"/"+ j;
                  Integer G = valLetra.get(letra); //precisei usar Integer aq e dps passar pra int pq int não pode ser null
                  if (G == null) 
                  {
                   throw new IllegalArgumentException("Erro nas letras do arquivo!");
                  }
                  int grau = G;
                  Vertice v = new Vertice(i, j, grau, letra);
                  //grafo g.put(nome, v);
                  //chamar aqui o método put do digrafo para adicionar o vértice no Hashmap utilizando <nome, v>
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Arquivo não encontrado.");
        }
        finally
        {
            teclado.close();
        }
    return g;
  }
}

