import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CalcadaGigantes
{
  public static void main(String[] args) {
    Digrafo g = lêArquivo();
   
  }

  public static Digrafo lêArquivo (){
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite o nome do arquivo .txt: ");
    String arquivo = teclado.nextLine();
    File caso = new File(arquivo);
    Digrafo g = new Digrafo();
    HashMap <Character, Integer> valLetra = new HashMap<>();
    valLetra.put('S', 1);
    for (int k = 0; k < 26; k++)
    {
      valLetra.put((char)('a'+ k),k+1); //pesquisei no chatGPT como fazer o calculo das letras char aumentando no alfabeto
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
                  int grau = valLetra.get(letra); 
                  Vertice v = new Vertice(i, j, grau, letra);
                  g.addVertice(nome, v);
                }
            }
            //fazer adds na listasAdj, com a condição if vertice ini.getGrau < vertice final.getGrau || final.getGrau == (ini.getGrau + 1);
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

