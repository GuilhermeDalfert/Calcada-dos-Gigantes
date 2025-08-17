# 🪨 Caminho Mais Curto na Calçada dos Gigantes  

## 📌 Problema  
O desafio é encontrar o **menor caminho** entre a pedra inicial **“S”** e uma pedra de altura máxima **“z”** na Calçada dos Gigantes.  
- Pode se mover apenas para **8 vizinhos** (horizontal, vertical, diagonal).  
- Só é permitido ir para pedras de mesma altura, menor altura ou no máximo um nível acima.  

---

## 💡 Solução  
O problema foi modelado como um **grafo direcionado**, onde:  
- Cada pedra é um **vértice** com altura e posição na matriz.  
- As arestas representam movimentações válidas.  

A busca do caminho mais curto foi feita com **BFS (Busca em Largura)**.  
O programa lê um `.txt` e retorna:  
- Número mínimo de passos até uma pedra “z”.  
- Tempo de execução do algoritmo.  

---

## 🛠️ Competências Demonstradas  
- **Algoritmos e Estruturas de Dados** → grafos, BFS.  
- **Modelagem de problemas reais em estruturas computacionais**.  
- **Manipulação de arquivos** e leitura de dados estruturados.  
- **Complexidade de algoritmos** (O(n)).  
- **Boas práticas em Java** (uso de classes, mapas, coleções).  
