import java.util.ArrayList;

public class Vertice {
    private int x;
    private int y;
    private int grau; //altura da pedra
    private char letra;
    private String nome; 
    private ArrayList <Vertice> listaAdj;

    public Vertice (int x, int y, int grau, char letra, String nome)
    {
        this.x = x;
        this.y = y;
        this.grau = grau;
        this.letra = letra;
        this.nome = nome;
        listaAdj = new ArrayList<>();
    }

    public int getX(){return x;}

    public int getY(){return y;}

    public int getGrau(){return grau;}

    public char getLetra(){return letra;}

    public String getNome(){return nome;}

    public ArrayList<Vertice> getListaAdj(){return listaAdj;}

    public void addLista(Vertice adj){listaAdj.add(adj);}    
}
