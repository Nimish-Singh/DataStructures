package graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacencyList {
    private List<List<Pair<Integer, Integer>>> list;

    AdjacencyList(int numberOfNodes) {
        list = new ArrayList<>(new ArrayList<>(numberOfNodes));
        IntStream.range(0, numberOfNodes).forEach(index -> list.add(0, new ArrayList<>()));
    }

    public void addEdge(int u, int v) {
        if (list.get(u).stream().map(Pair::getKey).noneMatch(x -> x.equals(v)))
            list.get(u).add(new Pair<>(v, 1));
    }

    public void addEdge(int u, int v, int weight) {
        if (list.get(u).stream().map(Pair::getKey).noneMatch(x -> x.equals(v)))
            list.get(u).add(new Pair<>(v, weight));
    }

    public void removeEdge(int u, int v) {
        List<Pair<Integer, Integer>> newAdjacency = list.get(u).stream().filter(x -> !x.getKey().equals(v)).collect(Collectors.toList());
        list.remove(u);
        list.add(u, newAdjacency);
    }

    public List<Integer> getAdjacentNodes(int node) {
        return list.get(node).stream().map(Pair::getKey).collect(Collectors.toList());
    }

    public boolean areAdjacent(int u, int v) {
        if (list.isEmpty())
            return false;
        return list.get(u).stream().map(Pair::getKey).anyMatch(node -> node.equals(v));
    }

    public int getWeightOfEdgeBetween(int u, int v) {
        int[] weight = list.get(u).stream()
                .filter(x -> x.getKey().equals(v))
                .map(Pair::getValue)
                .mapToInt(Integer::intValue)
                .toArray();
        return weight.length == 0 ? 0 : weight[0];
    }
}
