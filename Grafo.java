import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<String>> grafo;

  public Grafo() {
    grafo = new HashMap<>();
  }
    
  public void addEdge(String v, String w) {
    addToList(v, w);
    addToList(w, v);
  }

  public Iterable<String> getAdj(String v) {
    return grafo.get(v);
  }

  public Set<String> getVerts() {
    return grafo.keySet();
  }

  public String toDot() {
    // Usa um conjunto de arestas para evitar duplicatas
    Set<String> edges = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    sb.append("grafo {"+NEWLINE);
    sb.append("rankdir = LR;"+NEWLINE);
    sb.append("node [shape = circle];"+NEWLINE);
    for(String v: getVerts().stream().sorted().toList()) {
      for (String w: getAdj(v)) {
        String edge = v.compareTo(w) > 0 ? v + w : w + v;
        if(!edges.contains(edge)) {
          sb.append(v + " -- " + w + NEWLINE);
          edges.add(edge);
        }
      }
    }
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<String> addToList(String v, String w) {
    List<String> list = grafo.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(w);
    grafo.put(v, list);
    return list;
  }
}
