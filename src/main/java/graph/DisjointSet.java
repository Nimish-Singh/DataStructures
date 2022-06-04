package graph;

import java.util.stream.IntStream;

public class DisjointSet {
    // parent[i] = parent of node i
    private int[] parent;

    // rank[i] = rank of tree in which node i resides; for union by rank optimisation
    private int[] rank;

    // nodes are considered to be 0 -> (numberOfNodes - 1)
    public DisjointSet(int numberOfNodes) {
        parent = new int[numberOfNodes];
        rank = new int[numberOfNodes];

        IntStream.range(0, numberOfNodes).forEach(index -> parent[index] = index);
        IntStream.range(0, numberOfNodes).forEach(index -> parent[index] = 0);
    }

    // returns the parent/representative of the set to which node belongs
    public int find(int node) {
        if (parent[node] == node)
            return node;

        // optimisation- path compression
        parent[node] = find(node);
        return parent[node];
    }

    // joins the sets to which node1 and node 2 belong; thus the same node represents both the sets
    public void union(int node1, int node2) {
        int parentNode1 = find(node1);
        int parentNode2 = find(node2);

        int setToMergeTo = parentNode1;
        int setToMergeFrom = parentNode2;

        if (rank[parentNode1] < rank[parentNode2]) {
            setToMergeTo = parentNode2;
            setToMergeFrom = parentNode1;
        }

        parent[setToMergeFrom] = setToMergeTo;

        if (rank[setToMergeTo] == rank[setToMergeFrom])
            rank[setToMergeTo]++;
    }
}
