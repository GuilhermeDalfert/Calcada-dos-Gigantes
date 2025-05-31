import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Digrafo {
    private Map <String, Vertice> digrafo;

    public Digrafo ()
    {
        digrafo = new HashMap<>();
    }

    public void addVertice (String nome, Vertice v)
    {
        digrafo.put(nome, v);
    }
    
    public ArrayList<Vertice> todosVert()
    {
        ArrayList<Vertice> todosVertices = new ArrayList<>(digrafo.values());
        return todosVertices;
    }

    public Vertice getVertice (String nome)
    {
        Vertice v = digrafo.get(nome);
        return v;
    }

    public int getGrau (String nome)
    {
        Vertice v = digrafo.get(nome);
        int g = v.getGrau();
        return g;
    }

    public ArrayList<Vertice> getAdj (String nome)
    {
        Vertice v = digrafo.get(nome);
        return v.getListaAdj();
    }

    public void addAdj (String v, String l)
    {
        Vertice origem = digrafo.get(v);
        Vertice destino = digrafo.get(l);
        origem.addLista(destino);
    }
}
