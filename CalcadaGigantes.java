import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CalcadaGigantes
{
  public static void main(String[] args) {
    Digrafo g = montaGrafo();
   
  }

  public static Digrafo montaGrafo (){
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite o nome do arquivo .txt: ");
    String arquivo = teclado.nextLine();
    File caso = new File(arquivo);
    Digrafo g = new Digrafo();
    HashMap <Character, Integer> valLetra = new HashMap<>();
    valLetra.put('S', 1);
    for (int k = 0; k < 26; k++)
    {
      valLetra.put((char)('a'+ k), k+1); //pesquisei no chatGPT como fazer o calculo das letras char incrementando o valor do 'a' em ASCII
    }
    try (Scanner scan = new Scanner(caso);)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Vertice [][] matriz = new Vertice[y][x];

            scan.nextLine();
            String nome = null;
            for (int i = 0; i < y; i++)
            {
                String linha = scan.nextLine();
                for (int j = 0; j < x; j++)
                {
                  char letra = linha.charAt(j);
                  nome = i +"/"+ j;
                  int grau = valLetra.get(letra); 
                  Vertice v = new Vertice(j, i, grau, letra, nome);
                  matriz [i][j] = v;
                  g.addVertice(nome, v);
                  //System.out.println("Criando vértice: " + nome + ", letra: " + letra + ", grau: " + grau);
                }
            }
             for (int i = 0; i < y; i++)
            {
                for (int j = 0; j < x; j++)
                {
                  Vertice base = matriz[i][j];
                  for (int h = i-1; h < i+2; h++)
                  {
                    for (int l = j-1; l < j+2; l++)
                    {
                      if (h >= 0 && h < y && l >= 0 && l < x && !(h == i && l == j)) //impede que os indices saiam da matriz 
                      {                                                           // e que adicione o proprio vertice na lista de adj.
                        Vertice vizinho = matriz[h][l];
                        int b = base.getGrau();
                        int vi = vizinho.getGrau();
                        if (b > vi || vi == (b + 1) || b == vi)
                        {
                          g.addAdj(base.getNome(), vizinho.getNome());
                        }
                      }
                    }
                  }             
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

